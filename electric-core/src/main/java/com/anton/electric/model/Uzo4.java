package com.anton.electric.model;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * УЗО. Четырехполюсное. Трехфазное.
 *
 * @author Q-APE
 */
public class Uzo4 extends AbstractComponent {

    private Input inputL1;

    private Input inputL2;

    private Input inputL3;

    private Input inputN;

    private Output outputL1;

    private Output outputL2;

    private Output outputL3;

    private Output outputN;

    /**
     * Ток утечки (mA)
     */
    private int diffCurrent;

    public Uzo4(String id, String name, int current, int diffCurrent, double price) {
        super(id, name, 4, current, price);

        this.diffCurrent = diffCurrent;

        this.inputL1 = new Input(this, ConnectorType.L);
        this.inputL2 = new Input(this, ConnectorType.L);
        this.inputL3 = new Input(this, ConnectorType.L);
        this.inputN = new Input(this, ConnectorType.N);

        this.outputL1 = new Output(this, ConnectorType.L);
        this.outputL2 = new Output(this, ConnectorType.L);
        this.outputL3 = new Output(this, ConnectorType.L);
        this.outputN = new Output(this, ConnectorType.N);
    }

    public int getDiffCurrent() {
        return diffCurrent;
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
    public String spec() {
        return String.format("%dA/%dmA", current(), getDiffCurrent());
    }

    @Override
    public Set<Connector> inputs() {
        return Sets.newHashSet(inputL1, inputL2, inputL3, inputN);
    }

    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputL1, outputL2, outputL3, outputN);
    }

}
