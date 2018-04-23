package com.anton.electric.dsl

import com.anton.electric.dsl.support.GroovyUtils
import com.anton.electric.model.Component
import com.anton.electric.model.Output
import com.anton.electric.model.Socket
import com.anton.electric.model.Switchboard
import com.anton.electric.model.impl.Ground

/**
 *
 */
class SwitchboardBuilder {

    private Component root

    private Ground groundBus

    SwitchboardBuilder() {
        this.groundBus = new Ground()
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

    Socket outputSocket(Output outputL, Output outputN) {
        return new Socket("socket", "socket", 16, outputL, outputN, groundBus.outputG)
    }

}


