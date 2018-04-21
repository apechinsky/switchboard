package com.anton.electric.dsl

import com.anton.electric.dsl.support.GroovyUtils

/**
 * Switchboard DSL configuration bootstrapping script.
 *
 * <pre>{@code
 *
 *      switchboard {
 *          ...
 *          DSL code
 *          ...
 *      }
 *
 * }
 * </pre>
 *
 * @see SwitchboardLoader
 */
abstract class SwitchboardConfigScript extends Script {

    /**
     * Root DSL method.
     *
     * Creates SwitchboardBuilder and set it as closure delegate.
     *
     * @param closure configuration closure
     */
    void switchboard(Closure closure) {
        binding.builder = new SwitchboardBuilder()
        GroovyUtils.configure(closure, binding.builder)
    }

}
