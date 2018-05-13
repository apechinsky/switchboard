package com.anton.electric.model;

/**
 * Фабрика компоненто электрощитка.
 *
 * @author Q-APE
 */
public interface ComponentFactory {

    /**
     * Вводная линия 380В
     */
    Input380 input380(String id, String name, int current, double price);

    InputSwitch4 inputSwitch4(String id, String name, int current, double price);

    ReverseSwitch reverseSwitch(String id, String name, int current, double price);

    Uzo4 uzo4(String id, String name, int current, int diffCurrent, double price);

    Uzo uzo(String id, String name, int current, int diffCurrent, double price);

    Uzm uzm(String id, String name, int current, double price);

    VoltAmperMeter voltAmperMeter(String id, String name, int current, double price);

    CrossBus crossBus(String id, String name, int current, int size, double price);

    Diff diff(String id, String name, int current, int diffCurrent, double price);

}
