package com.anton.electric.model;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.MoreObjects;

/**
 * @author Q-APE
 */
public abstract class AbstractComponent implements Component {

    private String id;

    private String name;

    private double price;

    public AbstractComponent(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public Set<Component> getOutputComponents() {
        return outputs().stream()
            .flatMap(connector -> connector.getConnected().stream())
            .map(Connector::getComponent)
            .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
        toStringHelper.addValue(name());
        toStringHelper.add("id", id());
        toStringHelper.add("price", price());

        for (Connector connector : inputs()) {
            toStringHelper.add("Input: ", connector.getType());
        }
        for (Connector connector : outputs()) {
            toStringHelper.add("Output: ", connector.getType());
        }
        return toStringHelper.toString();
    }

}
