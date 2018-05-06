package com.anton.electric.render.dot;

import com.anton.electric.model.Component;
import com.anton.electric.render.IndentWriter;

/**
 * @author Q-APE
 */
public class NullBusRenderer<T extends Component> implements Renderer<T> {

    @Override
    public void render(T component, IndentWriter writer, DotSwitchboardRendererConfig config) {
        String idLabel = config.isRenderId() ? String.format("%s\\n", component.id()) : "";

        writer.println("%s [label=\"%s%s\\n%.2f\", style=filled, color=blue];",
            component.id(), idLabel, component.name(), component.price());

    }
}
