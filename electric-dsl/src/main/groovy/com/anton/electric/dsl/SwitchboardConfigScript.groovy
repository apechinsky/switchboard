package com.anton.electric.dsl

import com.anton.electric.dsl.support.GroovyUtils
import com.anton.electric.model.Switchboard

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
 * @see SwitchboardConfigLoader
 */
abstract class SwitchboardConfigScript extends Script {

    /**
     * Define switchboard with closure.
     *
     * Creates SwitchboardBuilder and set it as closure delegate.
     *
     * @param closure configuration closure
     */
    Switchboard switchboard(Closure closure) {
        binding.builder = new SwitchboardBuilder()
        GroovyUtils.configure(closure, binding.builder)

        return binding.builder.switchboard()
    }

    /**
     * Loads switchboard DSL from file
     *
     * @param file
     */
    Switchboard switchboard(String file) {
        return SwitchboardConfigLoader.loadFile(file)
    }
}
