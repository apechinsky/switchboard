package com.anton.electric;

import java.util.Set;

import org.junit.Test;

import com.anton.electric.model.Component;
import com.anton.electric.model.Connector;
import com.anton.electric.model.Link;
import com.anton.electric.model.Wire;

/**
 * @author Q-APE
 */
public class ModelTest {

    @Test
    public void name() throws Exception {
        Component root = null;

        Connector connector = null;
        Set<Link> links = connector.links();

        Link link = null;
        Wire wire = link.wire();
        Connector connector2 = link.peer(connector);
        Component component2 = connector2.component();

    }
}
