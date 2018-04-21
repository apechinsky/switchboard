package com.anton.electric.dsl

import com.anton.electric.dsl.support.GroovyUtils
import com.anton.electric.model.Component
import com.anton.electric.model.Output
import com.anton.electric.model.Socket
import com.anton.electric.model.Switchboard
import com.anton.electric.model.impl.Ground
import com.anton.electric.model.impl.NullBus

/**
 *
 */
class SwitchboardBuilder {

    private Component root

    private List<Component> nodes

    private Ground groundBus

    private NullBus nullBus

    SwitchboardBuilder() {
        this.groundBus = new Ground()
        this.nullBus = new NullBus()
    }

    Switchboard switchboard() {
        return new Switchboard(root, groundBus)
    }

    Switchboard switchboard(Closure closure) {
        def builder = new SwitchboardBuilder()
        GroovyUtils.configure(closure, builder)
        return builder.switchboard()
    }

    Component root(Component root) {
        this.root = root;
        return root
    }

    Ground groundBus() {
        return groundBus
    }

    NullBus nullBus() {
        return nullBus
    }

    Socket outputSocket(Output outputL) {
        return new Socket("socket", "socket", outputL, nullBus, groundBus)
    }

}


