package com.anton.electric.dsl

import org.codehaus.groovy.control.CompilerConfiguration

def binding = new Binding()

def compilerConfiguration = new CompilerConfiguration()
compilerConfiguration.setScriptBaseClass(SwitchboardConfigScript.name)

def shell = new GroovyShell(getClass().getClassLoader(), binding, compilerConfiguration)

shell.evaluate(new File(args[0]))
