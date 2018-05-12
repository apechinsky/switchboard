package com.anton.electric.dsl

import com.anton.electric.dsl.support.GroovyUtils
import com.anton.electric.model.Component
import com.anton.electric.model.Output
import com.anton.electric.model.Socket
import com.anton.electric.model.Switchboard
import com.anton.electric.model.impl.Diff
import com.anton.electric.model.impl.Ground
import com.anton.electric.model.impl.Input380

/**
 *
 */
class SwitchboardBuilder {

    private String name

    private Component root

    private Ground groundBus

    SwitchboardBuilder() {
        this.name = "noname"
        this.groundBus = new Ground()
    }

    Switchboard switchboard() {
        return new Switchboard(name, root, groundBus)
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

    Socket outputSocket(Diff diff) {
        return outputSocket(diff.outputL, diff.outputN)
    }

    def input400(String id, String name, int current, double price) {
        Input380 input = new Input380(id, name, current, price)
        components[id] = input

    }

    @Override
    Object getProperty(String property) {
        return components[property]
    }

    Map components = [:];
}


