package com.anton.electric.model.impl;

import java.util.Set;
import static java.math.BigDecimal.ZERO;
import static java.util.Collections.emptySet;

import com.anton.electric.model.AbstractComponent;
import com.anton.electric.model.Connector;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Output;
import com.google.common.collect.Sets;

/**
 * Земля
 *
 * @author Q-APE
 */
public class Ground extends AbstractComponent {

    private Output outputG;

    public Ground() {
        super("ground", "Ground", ZERO);

        outputG = new Output(this, ConnectorType.G);
    }

    public Output getOutputG() {
        return outputG;
    }

    @Override
    public Set<Connector> inputs() {
        return emptySet();
    }

    @Override
    public Set<Connector> outputs() {
        return Sets.newHashSet(outputG);
    }
}
