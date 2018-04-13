package com.anton.electric.model;

import java.util.Collections;
import java.util.Set;

/**
 * @author Q-APE
 */
public class Input extends Connector {

    public Input(Component component, ConnectorType type, Set<Link> links) {
        super(component, type, links);
    }

    public Input(Component component, ConnectorType type) {
        this(component, type, Collections.emptySet());
    }
}
