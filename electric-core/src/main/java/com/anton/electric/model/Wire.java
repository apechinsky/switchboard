package com.anton.electric.model;

import com.anton.electric.model.impl.WireImpl;

/**
 * @author Q-APE
 */
public interface Wire {

    static Wire create() {
        return new WireImpl();
    }

}
