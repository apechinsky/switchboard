package com.anton.electric.model;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Автомат-выключатель. Двуполюсный.
 *
 * @author Q-APE
 */
public class Switch2 extends AbstractComponent {

    private Input inputL;

    private Input inputN;

    private Output outputL;

    private Output outputN;

    public Switch2(String id, String name, int current, double price) {
        super(id, name, 2, current, price);

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
