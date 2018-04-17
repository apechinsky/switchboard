package com.anton.electric.model.impl;

import org.srplib.contract.Assert;

import com.anton.electric.model.Connector;
import com.anton.electric.model.Link;
import com.anton.electric.model.Wire;

/**
 * @author Q-APE
 */
public class LinkImpl implements Link {

    private Wire wire;

    private Connector first;

    private Connector second;

    public LinkImpl(Wire wire, Connector first, Connector second) {
        this.wire = wire;
        this.first = first;
        this.second = second;
    }

    @Override
    public Wire wire() {
        return wire;
    }

    @Override
    public Connector peer(Connector connector) {
        Assert.checkTrue(connector == first || connector == second,
            "Connector '%s' doesn't belong to the link %s", connector, this);

        return connector == first ? second : first;
    }

    @Override
    public Connector first() {
        return first;
    }

    @Override
    public Connector second() {
        return second;
    }
}
