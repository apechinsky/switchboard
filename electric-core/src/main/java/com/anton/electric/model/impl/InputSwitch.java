package com.anton.electric.model.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static java.util.Arrays.asList;

import com.anton.electric.model.AbstractComponent;
import com.anton.electric.model.Connector;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Input;
import com.anton.electric.model.Output;

/**
 * Вводной автомат
 *
 * @author Q-APE
 */
public class InputSwitch extends AbstractComponent {

    private Input inputL1;

    private Input inputL2;

    private Input inputL3;

    private Input inputN;

    private Output outputL1;

    private Output outputL2;

    private Output outputL3;

    private Output outputN;

    public InputSwitch(String id, String name, double price) {
        super(id, name, BigDecimal.valueOf(price));

        this.inputL1 = new Input(this, ConnectorType.L);
        this.inputL2 = new Input(this, ConnectorType.L);
        this.inputL3 = new Input(this, ConnectorType.L);
        this.inputN = new Input(this, ConnectorType.N);

        this.outputL1 = new Output(this, ConnectorType.L);
        this.outputL2 = new Output(this, ConnectorType.L);
        this.outputL3 = new Output(this, ConnectorType.L);
        this.outputN = new Output(this, ConnectorType.L);
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
        return Collections.unmodifiableSet(new HashSet<>(asList(inputL1, inputL2, inputL3, inputN)));
    }

    @Override
    public Set<Connector> outputs() {
        return Collections.unmodifiableSet(new HashSet<>(asList(outputL1, outputL2, outputL3, outputN)));
    }


}
