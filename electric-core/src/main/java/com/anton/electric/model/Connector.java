package com.anton.electric.model;

import java.util.Collections;
import java.util.Set;

/**
 * @author Q-APE
 */
public class Connector {

    private Component component;

    private ConnectorType type;

    private Set<Link> links;

    public Connector(Component component, ConnectorType type, Set<Link> links) {
        this.component = component;
        this.type = type;
        this.links = Collections.unmodifiableSet(links);
    }

    public Component getComponent() {
        return component;
    }

    public ConnectorType getType() {
        return type;
    }

    public Set<Link> getLinks() {
        return links;
    }
}
