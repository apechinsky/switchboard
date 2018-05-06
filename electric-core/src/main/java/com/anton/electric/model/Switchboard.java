package com.anton.electric.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.anton.electric.model.impl.Ground;
import com.google.common.base.MoreObjects;

/**
 * Электрощиток.
 *
 * @author Q-APE
 */
public class Switchboard {

    private String name;

    private Component root;

    private Ground ground;

    public Switchboard(String name, Component root, Ground ground) {
        this.name = name;
        this.root = root;
        this.ground = ground;
    }

    public String getName() {
        return name;
    }

    public Component getRoot() {
        return root;
    }

    public Ground getGround() {
        return ground;
    }

    public Set<Component> getComponents() {
        Map<String, Component> components = new HashMap<>();
        components.put(ground.id(), ground);
        collectLinked(root, components);
        return new HashSet<>(components.values());
    }

    public double getPrice() {
        return getComponents().stream()
            .collect(Collectors.summingDouble(Component::price));
    }

    public int getModules() {
        return getComponents().stream()
            .collect(Collectors.summingInt(Component::size));
    }

    private void collectLinked(Component component, Map<String, Component> collector) {

        collector.put(component.id(), component);

        component.getOutputComponents().stream()
            .forEach(linkedComponent -> collectLinked(linkedComponent, collector));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name", name)
            .add("components", getComponents().size())
            .add("price", getPrice())
            .add("modules", getModules())
            .toString();
    }
}
