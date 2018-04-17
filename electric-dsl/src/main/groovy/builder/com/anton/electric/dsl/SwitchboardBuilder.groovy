package builder.com.anton.electric.dsl

import builder.com.anton.electric.dsl.support.ObjectRegistry
import com.anton.electric.model.Component
import com.anton.electric.model.Switchboard
import com.anton.electric.model.impl.Ground
import com.anton.electric.model.impl.Null

/**
 *
 */
class SwitchboardBuilder {

    private ObjectRegistry registry = new ObjectRegistry()

    private Component root

    private List<Component> nodes

    private Ground groundBus

    private Null nullBus

    SwitchboardBuilder() {
        this.groundBus = new Ground()
        this.nullBus = new Null()
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

    Null nullBus() {
        return nullBus
    }

    def configure(Closure closure, def delegate) {
        closure.delegate = delegate
        closure.setResolveStrategy(Closure.DELEGATE_FIRST)
        closure.call()
    }


}


