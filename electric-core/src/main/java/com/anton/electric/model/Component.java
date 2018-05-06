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

    /**
     * Наименование компонента.
     */
    String name();

    /**
     * Количество занимаемых 18мм модулей на DIN рейке.
     */
    int size();

    /**
     * Ток в амперах.
     */
    int current();

    /**
     * Цена компонента
     */
    double price();

    /**
     * Лейбл компонента. Наименование + ключевые номиналы.
     */
    String spec();

    /**
     * Входы компонента.
     */
    Set<Connector> inputs();

    /**
     * Выходы компонента
     */
    Set<Connector> outputs();

    /**
     * Возвращает входные коннекторы указанного типа.
     *
     * @param type тип коннектора
     * @return множество коннекторов
     */
    default Set<Connector> inputs(ConnectorType type) {
        return inputs().stream()
            .filter(connector -> connector.getType() == type)
            .collect(Collectors.toSet());
    }

    /**
     * Возвращает выходные коннекторы указанного типа.
     *
     * @param type тип коннектора
     * @return множество коннекторов
     */
    default Set<Connector> outputs(ConnectorType type) {
        return outputs().stream()
            .filter(connector -> connector.getType() == type)
            .collect(Collectors.toSet());
    }

    /**
     * Возвращает компоненты, к которым подключен данный, через выходные коннекторы.
     */
    default Set<Component> getOutputComponents() {
        return outputs().stream()
            .flatMap(connector -> connector.getConnected().stream())
            .map(Connector::getComponent)
            .collect(Collectors.toSet());
    }


    /**
     * Соединяет выходы данного компонента с входами указанного компонента.
     *
     * <p>Позволяет соединить компоненты одной командой вместо соединения всех коннекторов по одному.</p>
     *
     * @param component компонент для соединения.
     * @throws IllegalArgumentException если указанный компонент несовместим с текущим
     * @see #isCompatible(Component)
     */
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

    /**
     * Проверяет совместимость подключения указанного компонента с данным.
     *
     * <p>Компонент совместим, если входы компонента соответствуют выходам текущего компонента.</p>
     *
     * @param component компонент для проверки
     * @return true если компонент совместим8
     */
    default boolean isCompatible(Component component) {
        return outputTypes().stream()
            .allMatch(type -> component.inputs(type).size() == this.outputs(type).size());
    }

    default Set<ConnectorType> outputTypes() {
        return outputs().stream().map(Connector::getType).collect(Collectors.toSet());
    }
}
