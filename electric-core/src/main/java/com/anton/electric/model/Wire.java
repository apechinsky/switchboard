package com.anton.electric.model;

/**
 * @author Q-APE
 */
public interface Wire {

    static Wire create() {
        return new WireImpl();
    }

}
