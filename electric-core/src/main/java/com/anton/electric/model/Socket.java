package com.anton.electric.model;

import java.util.Set;
import static java.util.Collections.emptySet;

import com.google.common.collect.Sets;

/**
 * Розетка или коннектор (фаза, ноль, заземление)
 *
 * @author Q-APE
 */
public class Socket extends AbstractComponent {

    private Output outputL;

    private Output outputN;

    private Output outputG;

    public Socket(String id, String name, int current, Output outputL, Output outputN, Output outputG) {
        super(id, name, 1, current, 0);

        this.outputL = outputL;
        this.outputN = outputN;
        this.outputG = outputG;
    }

    public Output getOutputL() {
        return outputL;
    }

    public Output getOutputN() {
        return outputN;
    }

    public Output getOutputG() {
        return outputG;
    }


    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputL, outputN, outputG);
    }
}
