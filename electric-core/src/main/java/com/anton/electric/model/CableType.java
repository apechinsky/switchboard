package com.anton.electric.model;

/**
 * @author Q-APE
 */
public enum CableType {

    VVG3_1_5(3, 1.5),

    VVG3_2_5(3, 2.5);

    private int wires;

    private double crossSection;

    CableType(int wires, double crossSection) {
        this.wires = wires;
        this.crossSection = crossSection;
    }

    public int getWires() {
        return wires;
    }

    public double getCrossSection() {
        return crossSection;
    }
}
