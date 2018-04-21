package com.anton.electric.dsl.support

/**
 * Groovy utilities
 *
 * @author Q-APE
 */
class GroovyUtils {

    /**
     * Configures closure with specified 'delegate' object and sets resolve strategy to {@link Closure#DELEGATE_FIRST}.
     *
     * @param closure closure to configure
     * @param delegate delegate object
     */
    static void configure(Closure closure, def delegate) {
        closure.delegate = delegate
        closure.setResolveStrategy(Closure.DELEGATE_FIRST)
        closure.call()
    }

}
