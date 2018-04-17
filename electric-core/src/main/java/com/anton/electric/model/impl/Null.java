package com.anton.electric.model.impl;

import java.util.Set;
import static java.math.BigDecimal.ZERO;

import com.anton.electric.model.AbstractComponent;
import com.anton.electric.model.Connector;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Input;
import com.anton.electric.model.Output;
import com.google.common.collect.Sets;

/**
 * @author Q-APE
 */
public class Null extends AbstractComponent {

    private Input inputN;

    private Output outputN;

    public Null() {
        super("null", "Null", ZERO);

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
