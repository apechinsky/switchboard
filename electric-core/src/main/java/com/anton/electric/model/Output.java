package com.anton.electric.model;

import java.util.Collections;
import java.util.Set;

import org.srplib.contract.Assert;

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

    public Output connect(Input input) {
        Assert.checkTrue(getType() == input.getType(), "Type %s is not compatible with %s", input.getType(), getType());

        
        return new Output(getComponent(), getType(), )

    }
}
