#!/usr/bin/env groovy
package builder.com.anton.electric.dsl

import com.anton.electric.model.Switchboard
import org.codehaus.groovy.control.CompilerConfiguration

public class SwitchboardLoader {

    public SwitchboardLoader() {

    }

    public Switchboard load(Reader reader) {
        def binding = new Binding()

        def compilerConfiguration = new CompilerConfiguration()
        compilerConfiguration.setScriptBaseClass(SwitchboardScript.name)

        def shell = new GroovyShell(getClass().getClassLoader(), binding, compilerConfiguration)
        shell.evaluate(reader)

        return binding.builder.switchboard()
    }
}

