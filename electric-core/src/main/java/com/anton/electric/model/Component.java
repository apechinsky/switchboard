package com.anton.electric.model;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Q-APE
 */
public interface Component {

    String id();

    String name();

    BigDecimal price();

    Set<Connector> inputs();

    Set<Connector> outputs();

}
