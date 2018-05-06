package com.anton.electric.model;

import java.util.Set;
import static java.util.Collections.emptySet;

import com.google.common.base.MoreObjects;

/**
 * Базовый класс для компонентов.
 *
 * <p>Хранит общие для всех компонентов атрибуты (id, name, price).</p>
 *
 * @author Q-APE
 */
public abstract class AbstractComponent implements Component {

    /**
     * Уникальный идентификатор
     */
    private String id;

    /**
     * Наименование
     */
    private String name;

    /**
     * Размер компонента в одинарных DIN модулях.
     */
    private int size;

    /**
     * Номинальный ток (A)
     */
    private int current;

    /**
     * Цена компонента
     */
    private double price;

    public AbstractComponent(String id, String name, int size, int current, double price) {
        this.id = id;
        this.name = name;
        this.current = current;
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public int current() {
        return current;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String spec() {
        return String.format("%dA", current);
    }

    @Override
    public Set<Connector> inputs() {
        return emptySet();
    }

    @Override
    public Set<Connector> outputs() {
        return emptySet();
    }

    @Override
    public String toString() {
        MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
        toStringHelper.addValue(name());
        toStringHelper.add("id", id());
        toStringHelper.add("current", current());
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
