package com.anton.electric.render.dot;

import com.anton.electric.model.Component;
import com.anton.electric.render.IndentWriter;

/**
 * @author Q-APE
 */
public class NullBusRenderer<T extends Component> implements Renderer<T> {

    @Override
    public void render(T component, IndentWriter writer) {
        writer.println("%1$s [label=\"%1$s\\n%2$s\\n%3$.2f\", style=filled, color=blue];",
            component.id(), component.name(), component.price());

    }
}
