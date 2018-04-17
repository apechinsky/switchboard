package com.anton.electric.model;

import java.math.BigDecimal;
import java.util.Set;
import static java.util.Collections.emptySet;

import com.google.common.collect.Sets;

/**
 * @author Q-APE
 */
public class Consumer extends AbstractComponent {

    private Input inputL;

    private Input inputN;

    private Input inputG;

    public Consumer(String id, String name, BigDecimal price) {
        super(id, name, price);

        inputL = new Input(this, ConnectorType.L);
        inputN = new Input(this, ConnectorType.N);
        inputG = new Input(this, ConnectorType.G);
    }

    public Input getInputL() {
        return inputL;
    }

    public Input getInputN() {
        return inputN;
    }

    public Input getInputG() {
        return inputG;
    }

    @Override
    public Set<Connector> inputs() {
        return Sets.newHashSet(inputL, inputN, inputG);
    }

    @Override
    public Set<Connector> outputs() {
        return emptySet();
    }
}
