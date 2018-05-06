package com.anton.electric.model;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Розетка или коннектор (фаза, ноль, заземление)
 *
 * @author Q-APE
 */
public class Socket2 extends AbstractComponent {

    private Output outputL;

    private Output outputN;

    public Socket2(String id, String name, int current, Output outputL, Output outputN) {
        super(id, name, 1, current, 0);

        this.outputL = outputL;
        this.outputN = outputN;
    }

    public Output getOutputL() {
        return outputL;
    }

    public Output getOutputN() {
        return outputN;
    }

    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputL, outputN);
    }
}
