package com.anton.electric.model;

import java.util.Collections;
import java.util.Set;

/**
 * @author Q-APE
 */
public class Output extends Connector {

    public Output(Component component, ConnectorType type, Set<Link> links) {
        super(component, type, links);
    }

    public Output(Component component, ConnectorType type) {
        super(component, type, Collections.emptySet());
    }
}
