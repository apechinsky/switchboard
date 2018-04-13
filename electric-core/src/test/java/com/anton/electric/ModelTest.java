package com.anton.electric;

import java.util.Set;

import org.junit.Test;

import com.anton.electric.model.Component;
import com.anton.electric.model.Connector;
import com.anton.electric.model.Link;
import com.anton.electric.model.Wire;
import com.anton.electric.model.impl.Input380;
import com.anton.electric.model.impl.InputSwitch;

/**
 * @author Q-APE
 */
public class ModelTest {

    @Test
    public void name() throws Exception {
        Input380 input380 = new Input380("input", "Ввод", 0);

        InputSwitch inputSwitch = new InputSwitch("inputSwitch", "Вводной автомат", 0);

        input380.getOutputL1().connect(inputSwitch.getInputL1());

        Connector connector = null;
        Set<Link> links = connector.links();

        Link link = null;
        Wire wire = link.wire();
        Connector connector2 = link.peer(connector);
        Component component2 = connector2.component();

    }
}
