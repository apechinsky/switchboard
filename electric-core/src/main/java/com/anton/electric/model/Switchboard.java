package com.anton.electric.model;

/**
 * Электрощиток.
 *
 * @author Q-APE
 */
public class Switchboard {

    private Component root;

    public Switchboard(Component root) {
        this.root = root;
    }

    public Component getRoot() {
        return root;
    }
}
