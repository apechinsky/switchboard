package com.anton.electric.model;

/**
 * @author Q-APE
 */
public interface Link {

    Wire wire();

    Connector peer(Connector connector);

    Connector first();

    Connector second();


}
