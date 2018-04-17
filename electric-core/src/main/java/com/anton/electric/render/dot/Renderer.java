package com.anton.electric.render.dot;

import com.anton.electric.render.IndentWriter;

/**
 * @author Q-APE
 */
public interface Renderer<T> {

    void render(T item, IndentWriter writer);

}
