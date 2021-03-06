package com.anton.electric.model;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Автомат-выключатель. Однополюсный.
 *
 * @author Q-APE
 */
public class Switch extends AbstractComponent {

    private Input inputL;

    private Output outputL;

    public Switch(String id, String name, int current, double price) {
        super(id, name, 1, current, price);

        this.inputL = new Input(this, ConnectorType.L);

        this.outputL = new Output(this, ConnectorType.L);
    }

    public Input getInputL() {
        return inputL;
    }

    public Output getOutputL() {
        return outputL;
    }

    @Override
    public Set<Connector> inputs() {
        return Sets.newHashSet(inputL);
    }

    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputL);
    }


}
