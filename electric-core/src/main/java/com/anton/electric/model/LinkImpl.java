package com.anton.electric.model;

import java.util.Objects;

import org.srplib.contract.Assert;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkImpl link = (LinkImpl) o;
        return Objects.equals(first, link.first) && Objects.equals(second, link.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
