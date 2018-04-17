package com.anton.electric;

import java.util.Collection;
import java.util.Set;

import org.junit.Test;

import com.anton.electric.model.Component;
import com.anton.electric.model.Connector;
import com.anton.electric.model.Link;
import com.anton.electric.model.Wire;
import com.anton.electric.model.impl.Ground;
import com.anton.electric.model.impl.Input380;
import com.anton.electric.model.impl.InputSwitch;
import com.anton.electric.model.impl.VoltageRelay;

/**
 * @author Q-APE
 */
public class ModelTest {

    @Test
    public void name() throws Exception {
        Ground ground = new Ground();
        Input380 input380 = new Input380("input", "Ввод", 0);

        InputSwitch inputSwitch = new InputSwitch("inputSwitch", "Вводной автомат", 0);

        input380.getOutputL1().connect(inputSwitch.getInputL1());
        input380.getOutputL2().connect(inputSwitch.getInputL2());
        input380.getOutputL3().connect(inputSwitch.getInputL3());
        input380.getOutputN().connect(inputSwitch.getInputN());

        VoltageRelay voltageRelay1 = new VoltageRelay("voltageRelay1", "Реле напряжения", 0);
        VoltageRelay voltageRelay2 = new VoltageRelay("voltageRelay2", "Реле напряжения", 0);
        VoltageRelay voltageRelay3 = new VoltageRelay("voltageRelay3", "Реле напряжения", 0);

        inputSwitch.getOutputL1().connect(voltageRelay1.getInputL());
        inputSwitch.getOutputL2().connect(voltageRelay2.getInputL());
        inputSwitch.getOutputL3().connect(voltageRelay3.getInputL());

        print(input380);

//        Connector connector = null;
//        Set<Link> links = connector.links();
//
//        Link link = null;
//        Wire wire = link.wire();
//        Connector connector2 = link.peer(connector);
//        Component component2 = connector2.component();

    }

    private void print(Component component) {

        System.out.println(component);

        component.outputs().stream()
            .map(Connector::getLinks)
            .flatMap(Collection::stream)
            .forEach(link -> {
                print(link.second().getComponent());
            });

    }
}
