
package com.anton.electric.dsl

import com.anton.electric.model.Switchboard
import org.codehaus.groovy.control.CompilerConfiguration

/**
 * Switchboard DSL config loader.
 */
public class SwitchboardConfigLoader {

    public static Switchboard load(File file) {
        return file.withReader { reader ->
            return new SwitchboardConfigLoader().load(reader)
        }
    }

    public static Switchboard loadFile(String file) {
        return load(new File(file))
    }

    /**
     * Loads Switchboard from specified reader.
     *
     * @param reader a reader of DSL switchboard config
     * @return Switchboard
     */
    public Switchboard load(Reader reader) {
        def binding = new Binding()

        def compilerConfiguration = new CompilerConfiguration()
        compilerConfiguration.setScriptBaseClass(SwitchboardConfigScript.name)

        def shell = new GroovyShell(getClass().getClassLoader(), binding, compilerConfiguration)
        shell.evaluate(reader)

        return binding.builder.switchboard()
    }
}

