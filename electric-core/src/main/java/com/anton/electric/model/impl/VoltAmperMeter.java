package com.anton.electric.model.impl;

import java.util.Set;

import com.anton.electric.model.AbstractComponent;
import com.anton.electric.model.Connector;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Input;
import com.anton.electric.model.Output;
import com.google.common.collect.Sets;

/**
 * Вольт-Ампер метр (ВАР).
 *
 * @author Q-APE
 */
public class VoltAmperMeter extends AbstractComponent {

    private Input inputL;

    private Input inputN;

    private Output outputL;

    private Output outputN;

    public VoltAmperMeter(String id, String name, double price) {
        super(id, name, price);

        this.inputL = new Input(this, ConnectorType.L);
        this.inputN = new Input(this, ConnectorType.N);

        this.outputL = new Output(this, ConnectorType.L);
        this.outputN = new Output(this, ConnectorType.N);
    }

    public Input getInputL() {
        return inputL;
    }

    public Input getInputN() {
        return inputN;
    }

    public Output getOutputL() {
        return outputL;
    }

    public Output getOutputN() {
        return outputN;
    }

    @Override
    public Set<Connector> inputs() {
        return Sets.newHashSet(inputL, inputN);
    }

    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputL, outputN);
    }


}