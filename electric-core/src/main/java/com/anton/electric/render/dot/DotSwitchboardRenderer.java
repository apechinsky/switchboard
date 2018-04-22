package com.anton.electric.render.dot;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.srplib.contract.Assert;

import com.anton.electric.model.Component;
import com.anton.electric.model.Link;
import com.anton.electric.model.Switchboard;
import com.anton.electric.model.impl.Ground;
import com.anton.electric.model.impl.NullBus;
import com.anton.electric.render.IndentWriter;

/**
 * Renders switchboard as directed graph with Dot language (Graphviz).
 *
 * @author Q-APE
 */
public class DotSwitchboardRenderer {

    private static final Map<Class, Renderer> RENDERERS = new LinkedHashMap<>();

    static {
        RENDERERS.put(Ground.class, new GroundRenderer());
        RENDERERS.put(NullBus.class, new NullBusRenderer());
        RENDERERS.put(Component.class, new ComponentRenderer());
        RENDERERS.put(Link.class, new LinkRenderer());
    }

    private String name;

    private IndentWriter writer;

    public DotSwitchboardRenderer(Writer writer, String name) {
        this.name = name;
        this.writer = new IndentWriter(writer);
    }

    public DotSwitchboardRenderer(OutputStream out, String name) {
        this(new OutputStreamWriter(out, StandardCharsets.UTF_8), name);
    }

    public void render(Switchboard switchboard) {
        writeHeader(switchboard);

        renderBody(switchboard);

        writeFooter();

        writer.flush();
    }

    private void renderBody(Switchboard switchboard) {

        List<Level> levels = getComponentsByLevels(switchboard);

        writer.indentInc();

        levels.forEach(level -> {
            Renderer<Object> renderer = getRenderer(level.getComponent());
            renderer.render(level.getComponent(), writer);
        });

        renderLinks(switchboard);
    }

    private List<Level> getComponentsByLevels(Switchboard switchboard) {
        Set<Level> levels = new TreeSet<>(Comparator.comparing(Level::getId));

        levels.add(new Level(switchboard.getGround(), 0));

        collectComponents(switchboard.getRoot(), levels, 0);

        List<Level> list = new ArrayList<>(levels);
        list.sort(Comparator.comparing(Level::getDepth));

        return list;
    }

    private void collectComponents(Component component, Set<Level> components, int depth) {

        components.add(new Level(component, depth));

        component.getOutputComponents().stream()
            .forEach(c -> collectComponents(c, components, depth + 1));
    }

    private <T> Renderer<T> getRenderer(T item) {
        return RENDERERS.entrySet().stream()
            .filter(entry -> entry.getKey().isInstance(item))
            .map(Map.Entry::getValue)
            .findFirst()
            .orElseThrow(() -> Assert.failure("No renderer for item '%s'", item));
    }

    private void renderLinks(Switchboard switchboard) {
        Set<Link> visited = new HashSet<>();
        renderLinks(switchboard.getRoot(), visited);
        renderLinks(switchboard.getGround(), visited);
    }

    private void renderLinks(Component root, Set<Link> visited) {

        root.outputs().stream()
            .flatMap(connector -> connector.getLinks().stream())
            .filter(link -> !visited.contains(link))
            .forEach(link -> {
                getRenderer(link).render(link, writer);
                visited.add(link);
            });

        root.getOutputComponents().stream()
            .forEach(link -> renderLinks(link, visited));
    }

    private void writeHeader(Switchboard switchboard) {
        writer.indent(0);

        writer.println("digraph %s {", name);

        writer.println("label=\"Components: %d, Modules: %d, Price: %.2f\";",
            switchboard.getComponents().size(), switchboard.getModules(), switchboard.getPrice());

        writer.println("node [shape=box];");
    }

    private void writeFooter() {
        writer.indent(0);
        writer.println("}");
    }

    static class Level {

        private Component component;

        private int depth;

        public Level(Component component, int depth) {
            this.component = component;
            this.depth = depth;
        }

        public String getId() {
            return component.id();
        }

        public Component getComponent() {
            return component;
        }

        public int getDepth() {
            return depth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Level level = (Level) o;
            return Objects.equals(component.id(), level.component.id());
        }

        @Override
        public int hashCode() {
            return Objects.hash(component.id());
        }

        @Override
        public String toString() {
            return String.format("Level [%d, %s]", depth, component);
        }
    }

}
