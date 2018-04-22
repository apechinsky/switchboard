package com.anton.electric.model;

import com.google.common.base.MoreObjects;

/**
 * Базовый класс для компонентов.
 *
 * <p>Хранит общие для всех компонентов атрибуты (id, name, price).</p>
 *
 * @author Q-APE
 */
public abstract class AbstractComponent implements Component {

    private String id;

    private String name;

    private int size;

    private double price;

    public AbstractComponent(String id, String name, int size, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
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

    public int size() {
        return size;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String toString() {
        MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
        toStringHelper.addValue(name());
        toStringHelper.add("id", id());
        toStringHelper.add("size", size());
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
