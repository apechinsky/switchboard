package com.anton.electric.model;

import java.util.Set;
import java.util.stream.Collectors;

import org.srplib.contract.Assert;

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

    default Set<Connector> inputs(ConnectorType type) {
        return inputs().stream()
            .filter(connector -> connector.getType() == type)
            .collect(Collectors.toSet());
    }

    default Set<Connector> outputs(ConnectorType type) {
        return outputs().stream()
            .filter(connector -> connector.getType() == type)
            .collect(Collectors.toSet());
    }

    Set<Component> getOutputComponents();

    default void connect(Component component) {
        Assert.checkTrue(isCompatible(component), "Can't autowire component %s to %s. " +
            "Component are not connector compatible. ", this, component);

        outputs().stream().forEach(thisConnector -> {
            Set<Connector> candidates = component.inputs(thisConnector.getType());

            candidates.stream().findFirst().ifPresent(peerConnector -> {
                ((Output)thisConnector).connect(((Input)peerConnector));
            });
        });

    }

    default boolean isCompatible(Component component) {
        return types().stream().allMatch(type -> this.inputs(type).size() == component.outputs(type).size());
    }

    default Set<ConnectorType> types() {
        return outputs().stream().map(Connector::getType).collect(Collectors.toSet());
    }
}
