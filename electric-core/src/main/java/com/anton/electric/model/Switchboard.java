package com.anton.electric.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.MoreObjects;

/**
 * Электрощиток.
 *
 * @author Q-APE
 */
public class Switchboard {

    private String name;

    private Map<String, Component> components;

    private Ground ground;

    public Switchboard(String name, Map<String, Component> components, Ground ground) {
        this.name = name;
        this.components = components;
        this.ground = ground;
    }

    public String getName() {
        return name;
    }

    public Collection<Component> getInputs() {
        return components.values().stream()
            .filter(Input380.class::isInstance)
            .collect(Collectors.toList());
    }

    public Ground getGround() {
        return ground;
    }

    public Set<Component> getComponents() {
        Set<Component> components = new HashSet<>();
        components.add(ground);
        components.addAll(this.components.values());
        return components;
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
