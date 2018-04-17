package com.anton.electric.model.impl;

import java.math.BigDecimal;
import java.util.Set;

import com.anton.electric.model.AbstractComponent;
import com.anton.electric.model.Connector;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Input;
import com.anton.electric.model.Output;
import com.google.common.collect.Sets;

/**
 * Автомат-выключатель.
 *
 * @author Q-APE
 */
public class Switch extends AbstractComponent {

    private Input inputL;

    private Output outputL;

    public Switch(String id, String name, double price) {
        super(id, name, price);

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
