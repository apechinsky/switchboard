package builder.com.anton.electric.dsl

import builder.com.anton.electric.dsl.support.ObjectRegistry
import com.anton.electric.model.Component
import com.anton.electric.model.Output
import com.anton.electric.model.*
import com.anton.electric.model.impl.Ground
import com.anton.electric.model.impl.NullBus

/**
 *
 */
class SwitchboardBuilder {

    private ObjectRegistry registry = new ObjectRegistry()

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


    def configure(Closure closure, def delegate) {
        closure.delegate = delegate
        closure.setResolveStrategy(Closure.DELEGATE_FIRST)
        closure.call()
    }


}


