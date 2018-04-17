package com.anton.electric.graphviz;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.anton.electric.model.Component;
import com.anton.electric.model.Switchboard;

/**
 * @author Q-APE
 */
public class DotWriter {

    private String name;

    private PrintWriter writer;

    public DotWriter(Writer writer, String name) {
        this.name = name;
        this.writer = new PrintWriter(new BufferedWriter(writer));

    }

    public DotWriter(OutputStream out, String name) {
        this(new OutputStreamWriter(out, StandardCharsets.UTF_8), name);
    }

    public void write(Switchboard switchboard) {
        writeHeader();

        writeBody(switchboard.getRoot());

        writeFooter();

        writer.flush();
    }

    private void writeBody(Component root) {
        SortedSet<Level> components = new TreeSet<>(Comparator.comparing(Level::getId));
        collectComponents(root, components, 0);

        components.forEach(c -> {
            writer.printf("%s%s %n", getIndent(1), getDeclaration(c.getComponent()));
        });

        writeLinks(root);
    }

    private void collectComponents(Component component, Set<Level> components, int depth) {

        components.add(new Level(component, depth));

        component.getOutputComponents().stream().forEach(c -> collectComponents(c, components, depth + 1));
    }

    private String getIndent(int depth) {
        char[] indent = new char[depth * 4];
        Arrays.fill(indent, ' ');
        return new String(indent);
    }

    private void writeLinks(Component root) {

    }

    private String getDeclaration(Component root) {
        return String.format("%s [label=\"%s\"];", root.id(), root.name());
    }

    private PrintWriter writeHeader() {
        return writer.printf("digraph %s { %n", name);
    }

    private PrintWriter writeFooter() {
        return writer.printf("} %n");
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
    }

}
