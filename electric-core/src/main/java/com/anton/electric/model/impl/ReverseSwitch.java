package com.anton.electric.model.impl;

import java.util.Set;

import com.anton.electric.model.AbstractComponent;
import com.anton.electric.model.Connector;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Input;
import com.anton.electric.model.Output;
import com.google.common.collect.Sets;

/**
 * Реверсивный рубильник
 *
 * @author Q-APE
 */
public class ReverseSwitch extends AbstractComponent {

    private Input inputL1_1;

    private Input inputL2_1;

    private Input inputL3_1;

    private Input inputL1_2;

    private Input inputL2_2;

    private Input inputL3_2;

    private Output outputL1;

    private Output outputL2;

    private Output outputL3;

    public ReverseSwitch(String id, String name, int current, double price) {
        super(id, name, 4, current, price);

        this.inputL1_1 = new Input(this, ConnectorType.L);
        this.inputL2_1 = new Input(this, ConnectorType.L);
        this.inputL3_1 = new Input(this, ConnectorType.L);

        this.inputL1_2 = new Input(this, ConnectorType.L);
        this.inputL2_2 = new Input(this, ConnectorType.L);
        this.inputL3_2 = new Input(this, ConnectorType.L);

        this.outputL1 = new Output(this, ConnectorType.L);
        this.outputL2 = new Output(this, ConnectorType.L);
        this.outputL3 = new Output(this, ConnectorType.L);
    }

    public Input getInputL1_1() {
        return inputL1_1;
    }

    public Input getInputL2_1() {
        return inputL2_1;
    }

    public Input getInputL3_1() {
        return inputL3_1;
    }

    public Input getInputL1_2() {
        return inputL1_2;
    }

    public Input getInputL2_2() {
        return inputL2_2;
    }

    public Input getInputL3_2() {
        return inputL3_2;
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

    @Override
    public Set<Connector> inputs() {
        return Sets.newHashSet(inputL1_1, inputL2_1, inputL3_1, inputL1_2, inputL2_2, inputL3_2);
    }

    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputL1, outputL2, outputL3);
    }


}
