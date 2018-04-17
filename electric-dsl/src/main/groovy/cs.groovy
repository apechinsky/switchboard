#!/usr/bin/env groovy
import com.anton.electric.graphviz.DotWriter
import org.codehaus.groovy.control.CompilerConfiguration
import builder.com.anton.electric.dsl.SwitchboardScript


def binding = new Binding()

def compilerConfiguration = new CompilerConfiguration()
compilerConfiguration.setScriptBaseClass(SwitchboardScript.name)

def shell = new GroovyShell(getClass().getClassLoader(), binding, compilerConfiguration)
shell.evaluate (new File("config.groovy"))

println binding.builder.switchboard()

new DotWriter(System.out, "Electric").write(binding.builder.switchboard())
