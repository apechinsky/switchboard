package com.anton.electric.dsl

import com.anton.electric.model.*

/**
 *
 */
class SwitchboardBuilder extends GroovyObjectSupport {

    private String name

    private Ground groundBus

    private Map components

    private Consumers consumers

    private Set<Group> groups

    SwitchboardBuilder() {
        this.name = "noname"
        this.components = [:]
        this.groundBus = new Ground()
        this.groups = []
    }

    Switchboard switchboard() {
        return new Switchboard(name, components, groundBus, consumers, groups)
    }

    String getName() {
        return name
    }

    Ground groundBus() {
        return groundBus
    }

    Consumers getConsumers() {
        return consumers
    }

    Socket outputSocket(Output outputL, Output outputN) {
        return new Socket("socket", "socket", 16, outputL, outputN, groundBus.outputG)
    }

    Socket outputSocket(Diff diff) {
        return outputSocket(diff.outputL, diff.outputN)
    }

    void group(String id, String name, Collection components) {
        groups.add(new Group(id, name, new HashSet<>(components)))
    }

    def register(Component component) {
        components[component.id()] = component
        return component
    }

    /**
     * Обработчик несуществующих свойств класса.
     *
     * <p>Используется для обращения к созданному ранее компоненту по его идентификатору.
     *
     * <pre>
     *     Input380('generator', ...)
     *     ...
     *
     *     generator.connect(reverseSwitch)
     * </pre>
     *
     * </p>
     */
    @Override
    Object getProperty(String property) {
        def component = components[property]
//        Assert.checkNotNull(component, "Component with id '%s' not found!", property)
        return component ?: super.getProperty(property)
    }

    /**
     * Обработчик несуществующих методов.
     *
     * <p>Используется для преобразование вызова метода в вызов одноименного конструктора подкласса Component</p>.
     *
     * <p>Метод позволяет упростить создание компонентов. Заменить конструкцию
     * <pre>
     *     def component = new Switch(...)
     * </pre>
     * на
     * <pre>
     *     Switch(...)
     * </pre>
     *
     * <ul>
     *     <li>создает экземпляр класса с именем 'name' и конструктором с параметрами 'args'.</li>
     *     <li>регистрирует созданный экземпляр компонента в модели.</li>
     * </ul>
     *
     */
    @Override
    Object invokeMethod(String name, Object args) {

        Class<?> componentClass = findComponentClass(name)

        Component component = componentClass.newInstance(args)

        return register(component)
    }

    private Class<?> findComponentClass(String name) {
        String modelPackage = Component.class.package.name

        String className = "${modelPackage}.${name.capitalize()}"

        Class componentClass = Class.forName(className)
        componentClass
    }
}


