package com.anton.electric.model;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Компонент электросистемы (узо, автомат, реле и т.п.).
 *
 * <p>Конкретный компонент имеет предопределенное количество входов и выходов. Реализации должны
 * объявлять свои выходы отдельными методами. Общие методы {@link #inputs()}, {@link #outputs()} используются
 * для вычислений (обход графа компонентов, и т.п.)</p>
 *
 * @author Q-APE
 */
public interface Component {

    /**
     * Уникальный идентификатор компонента
     */
    String id();

    String name();

    double price();

    /**
     * Входы компонента.
     */
    Set<Connector> inputs();

    /**
     * Выходы компонента
     */
    Set<Connector> outputs();

    Set<Component> getOutputComponents();
}
