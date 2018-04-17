package com.anton.electric.model;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.base.MoreObjects;

/**
 * @author Q-APE
 */
public class Input extends Connector {

    public Input(Component component, ConnectorType type, List<Link> links) {
        super(component, type, links);
    }

    public Input(Component component, ConnectorType type) {
        this(component, type, Collections.emptyList());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("type", getType())
            .toString();
    }
}
