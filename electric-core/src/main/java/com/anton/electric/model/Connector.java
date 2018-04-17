package com.anton.electric.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Коннектор. Описывает точку подключния проводов компонента.
 *
 * @author Q-APE
 */
public class Connector {

    /**
     * Обратная ссылка на компонент, которому принадлежит коннектор.
     */
    private Component component;

    /**
     * Тип коннектора
     */
    private ConnectorType type;

    /**
     * Спиок связей коннектора с другими коннекторами.
     */
    private List<Link> links;

    public Connector(Component component, ConnectorType type, List<Link> links) {
        this.component = component;
        this.type = type;
        this.links = Collections.unmodifiableList(links);
    }

    public Connector(Component component, ConnectorType type) {
        this(component, type, Collections.emptyList());
    }

    public Component getComponent() {
        return component;
    }

    public ConnectorType getType() {
        return type;
    }

    public List<Link> getLinks() {
        return links;
    }

    protected void addLink(Link link) {
        List<Link> links = new ArrayList<>(this.links);
        links.add(link);
        this.links = Collections.unmodifiableList(links);
    }

    public List<Connector> getConnected() {
        return links.stream()
            .map(link -> link.peer(this))
            .collect(Collectors.toList());
    }
}
