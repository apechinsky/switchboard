package com.anton.electric.model.impl;

import java.util.Set;

import com.anton.electric.model.AbstractComponent;
import com.anton.electric.model.Connector;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Input;
import com.anton.electric.model.Output;
import com.google.common.collect.Sets;

/**
 * Земля
 *
 * @author Q-APE
 */
public class Ground extends AbstractComponent {

    private Input inputG;

    private Output outputG;

    public Ground() {
        super("ground", "Земля", 0, 16, 0);

        inputG = new Input(this, ConnectorType.G);
        outputG = new Output(this, ConnectorType.G);
    }

    public Input getInputG() {
        return inputG;
    }

    public Output getOutputG() {
        return outputG;
    }

    @Override
    public Set<Connector> inputs() {
        return Sets.newHashSet(inputG);
    }

    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputG);
    }
}
