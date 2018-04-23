package com.anton.electric.model;

import java.util.Set;
import static java.util.Collections.emptySet;

import com.google.common.collect.Sets;

/**
 * Трехфазный потребитель (фаза, ноль, заземление)
 *
 * <ul>
 *     <li>розетка</li>
 *     <li>плита</li>
 *     <li>котел</li>
 * </ul>
 *
 * @author Q-APE
 */
public class Consumer3 extends AbstractComponent {

    private Input inputL1;

    private Input inputL2;

    private Input inputL3;

    private Input inputN;

    private Input inputG;

    public Consumer3(String id, String name, int current, double price) {
        super(id, name, 0, current, price);

        inputL1 = new Input(this, ConnectorType.L);
        inputL2 = new Input(this, ConnectorType.L);
        inputL3 = new Input(this, ConnectorType.L);
        inputN = new Input(this, ConnectorType.N);
        inputG = new Input(this, ConnectorType.G);
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

    public Input getInputG() {
        return inputG;
    }

    @Override
    public Set<Connector> inputs() {
        return Sets.newHashSet(inputL1, inputL2, inputL3, inputN, inputG);
    }

}
