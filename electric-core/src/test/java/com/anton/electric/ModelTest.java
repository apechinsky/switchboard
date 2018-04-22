package com.anton.electric;

import java.util.Collection;

import org.junit.Test;

import com.anton.electric.model.Component;
import com.anton.electric.model.Connector;
import com.anton.electric.model.impl.Ground;
import com.anton.electric.model.impl.Input380;
import com.anton.electric.model.impl.InputSwitch;
import com.anton.electric.model.impl.Uzm;

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

        Uzm uzm1 = new Uzm("uzm1", "Реле напряжения", 0);
        Uzm uzm2 = new Uzm("uzm2", "Реле напряжения", 0);
        Uzm uzm3 = new Uzm("uzm3", "Реле напряжения", 0);

        inputSwitch.getOutputL1().connect(uzm1.getInputL());
        inputSwitch.getOutputL2().connect(uzm2.getInputL());
        inputSwitch.getOutputL3().connect(uzm3.getInputL());

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
