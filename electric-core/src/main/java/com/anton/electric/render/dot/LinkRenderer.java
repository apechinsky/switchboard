package com.anton.electric.render.dot;

import java.util.HashMap;
import java.util.Map;

import com.anton.electric.model.Component;
import com.anton.electric.model.ConnectorType;
import com.anton.electric.model.Link;
import com.anton.electric.render.IndentWriter;

/**
 * @author Q-APE
 */
public class LinkRenderer implements Renderer<Link> {

    private static Map<ConnectorType, String> connectorColors = new HashMap<>();

    static {
        connectorColors.put(ConnectorType.G, "green");
        connectorColors.put(ConnectorType.N, "blue");
        connectorColors.put(ConnectorType.L, "red");
    }

    public void render(Link item, IndentWriter writer) {
        Component first = item.first().getComponent();
        Component second = item.second().getComponent();

        writer.println("%s -> %s [label=\"%s\", color=%s]", first.id(), second.id(), "", getColor(item));
    }

    private String getColor(Link link) {
        return connectorColors.get(link.first().getType());
    }

}
