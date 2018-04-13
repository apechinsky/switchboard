package com.anton.electric.model;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Q-APE
 */
public abstract class AbstractComponent implements Component {

    private String id;

    private String name;

    private BigDecimal price;

    public AbstractComponent(String id, String name, BigDecimal price) {
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
    public BigDecimal price() {
        return price;
    }

}
