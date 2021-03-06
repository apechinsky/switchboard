package com.anton.electric.model;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Нулевая шина.
 *
 * @author Q-APE
 */
public class NullBus extends AbstractComponent {

    private static final int CURRENT = 100;

    private Input inputN;

    private Output outputN;

    public NullBus(String id, String name, int price) {
        super(id, name, 1, CURRENT, price);

        inputN = new Input(this, ConnectorType.N);
        outputN = new Output(this, ConnectorType.N);
    }

    public Input getInputN() {
        return inputN;
    }

    public Output getOutputN() {
        return outputN;
    }

    @Override
    public Set<Connector> inputs() {
        return Sets.newHashSet(inputN);
    }

    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputN);
    }

}
