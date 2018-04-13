package com.anton.electric.model.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import com.anton.electric.model.AbstractComponent;
import com.anton.electric.model.Connector;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Input;
import com.anton.electric.model.Output;

/**
 * @author Q-APE
 */
public class Input380 extends AbstractComponent {

    private Input inputL1;

    private Input inputL2;

    private Input inputL3;

    private Input inputN;

    private Output outputL1;

    private Output outputL2;

    private Output outputL3;

    private Output outputN;

    public Input380(String id, String name, BigDecimal price) {
        super(id, name, price);

        this.inputL1 = new Input(this, ConnectorType.L);
        this.inputL2 = new Input(this, ConnectorType.L);
        this.inputL3 = new Input(this, ConnectorType.L);
        this.inputN = new Input(this, ConnectorType.N);

        this.outputL1 = new Output(this, ConnectorType.L);
        this.outputL2 = new Output(this, ConnectorType.L);
        this.outputL3 = new Output(this, ConnectorType.L);
        this.outputN = new Output(this, ConnectorType.L);
    }

    @Override
    public Set<Connector> inputs() {
        return Collections.unmodifiableSet(g);
    }

    @Override
    public Set<Connector> outputs() {
        return null;
    }


}
