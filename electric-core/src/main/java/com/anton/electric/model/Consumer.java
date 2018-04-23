package com.anton.electric.model;

import java.util.Set;
import static java.util.Collections.emptySet;

import com.google.common.collect.Sets;

/**
 * Стандартный потребитель (фаза, ноль, заземление)
 *
 * <ul>
 *     <li>розетка</li>
 *     <li>стиральная машина</li>
 *     <li>посудомоечная машина</li>
 *     <li>плита</li>
 * </ul>
 *
 * @author Q-APE
 */
public class Consumer extends AbstractComponent {

    private Input inputL;

    private Input inputN;

    private Input inputG;

    public Consumer(String id, String name, int current, double price) {
        super(id, name, 0, current, price);

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

}
