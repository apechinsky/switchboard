package com.anton.electric.model;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * УЗО. Двуполюсное.
 *
 * @author Q-APE
 */
public class Uzo extends AbstractComponent {

    private Input inputL;

    private Input inputN;

    private Output outputL;

    private Output outputN;

    /**
     * Ток утечки (mA)
     */
    private int diffCurrent;

    public Uzo(String id, String name, int current, int diffCurrent, double price) {
        super(id, name, 2, current, price);

        this.diffCurrent = diffCurrent;

        this.inputL = new Input(this, ConnectorType.L);
        this.inputN = new Input(this, ConnectorType.N);

        this.outputL = new Output(this, ConnectorType.L);
        this.outputN = new Output(this, ConnectorType.N);
    }

    public int getDiffCurrent() {
        return diffCurrent;
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
    public String spec() {
        return String.format("%dA/%dmA", current(), getDiffCurrent());
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
