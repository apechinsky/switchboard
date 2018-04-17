package com.anton.electric.model;

import java.util.Collections;
import java.util.List;

import org.srplib.contract.Assert;

import com.google.common.base.MoreObjects;

/**
 * @author Q-APE
 */
public class Output extends Connector {

    public Output(Component component, ConnectorType type, List<Link> links) {
        super(component, type, links);
    }

    public Output(Component component, ConnectorType type) {
        super(component, type, Collections.emptyList());
    }

    public void connect(Input input) {
        Assert.checkTrue(getType() == input.getType(), "Can't connect %s to %s. " +
            "Type %s is not compatible with %s", this, input, input.getType(), getType());

        Link link = Link.create(Wire.create(), this, input);

        addLink(link);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("type", getType())
            .toString();
    }
}
