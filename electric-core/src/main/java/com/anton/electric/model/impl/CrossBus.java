package com.anton.electric.model.impl;

import java.util.Set;

import com.anton.electric.model.AbstractComponent;
import com.anton.electric.model.Component;
import com.anton.electric.model.Connector;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Input;
import com.anton.electric.model.Output;
import com.anton.electric.model.Socket2;
import com.google.common.collect.Sets;

/**
 * Кросс-модуль. 3-фазный.
 *
 * @author Q-APE
 */
public class CrossBus extends AbstractComponent {

    private Input inputL1;

    private Input inputL2;

    private Input inputL3;

    private Input inputN;

    private Output outputL1;

    private Output outputL2;

    private Output outputL3;

    private Output outputN;

    public CrossBus(String id, String name, int current, int size, double price) {
        super(id, name, size, current, price);

        this.inputL1 = new Input(this, ConnectorType.L);
        this.inputL2 = new Input(this, ConnectorType.L);
        this.inputL3 = new Input(this, ConnectorType.L);
        this.inputN = new Input(this, ConnectorType.N);

        this.outputL1 = new Output(this, ConnectorType.L);
        this.outputL2 = new Output(this, ConnectorType.L);
        this.outputL3 = new Output(this, ConnectorType.L);
        this.outputN = new Output(this, ConnectorType.N);
    }

    public Input getInputL1() {
        return inputL1;
    }

    public Input getInputL2() {
        return inputL2;
    }

    public Input getInputL3() {
        return inputL3;
    }

    public Input getInputN() {
        return inputN;
    }

    public Output getOutputL1() {
        return outputL1;
    }

    public Output getOutputL2() {
        return outputL2;
    }

    public Output getOutputL3() {
        return outputL3;
    }

    public Output getOutputN() {
        return outputN;
    }

    @Override
    public Set<Connector> inputs() {
        return Sets.newHashSet(inputL1, inputL2, inputL3, inputN);
    }

    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputL1, outputL2, outputL3, outputN);
    }

    /**
     * Соединяет пару (фаза 1, ноль) с двуполюсным компонентом.
     */
    public void connectL1(Component component) {
        connectSocket(outputL1, component);
    }

    /**
     * Соединяет пару (фаза 2, ноль) с двуполюсным компонентом.
     */
    public void connectL2(Component component) {
        connectSocket(outputL2, component);
    }

    /**
     * Соединяет пару (фаза 2, ноль) с двуполюсным компонентом.
     */
    public void connectL3(Component component) {
        connectSocket(outputL3, component);
    }

    private void connectSocket(Output outputL, Component component) {
        Socket2 socketL = new Socket2("socket", "socket", current(), outputL, outputN);
        socketL.connect(component);
    }

}
