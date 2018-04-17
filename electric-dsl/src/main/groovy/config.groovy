import com.anton.electric.model.Component
import com.anton.electric.model.Consumer
import com.anton.electric.model.impl.*

switchboard {

    Component input = root(new Input380('input380', 'Ввод', 0))

    def inputSwitch = new InputSwitch('inputSwitch', 'Вводной автомат', 0)

    def voltageRelay2 = new VoltageRelay('voltageRelay2', 'Реле напряжения', 0)
    def voltageRelay1 = new VoltageRelay('voltageRelay1', 'Реле напряжения', 0)
    def voltageRelay3 = new VoltageRelay('voltageRelay3', 'Реле напряжения', 0)

    def uzo1 = new Uzo('uzo1', 'УЗО', 0)
    def uzo2 = new Uzo('uzo2', 'УЗО', 0)
    def uzo3 = new Uzo('uzo3', 'УЗО', 0)
    def uzo4 = new Uzo('uzo4', 'УЗО', 0)
    def uzo5 = new Uzo('uzo5', 'УЗО', 0)
    def uzo6 = new Uzo('uzo6', 'УЗО', 0)
    def uzo7 = new Uzo('uzo7', 'УЗО', 0)

    def switch1 = new Switch('uzo1', 'УЗО', 0)
    def switch2 = new Switch('uzo2', 'УЗО', 0)
    def switch3 = new Switch('uzo3', 'УЗО', 0)
    def switch4 = new Switch('uzo4', 'УЗО', 0)
    def switch5 = new Switch('uzo5', 'УЗО', 0)
    def switch6 = new Switch('uzo6', 'УЗО', 0)
    def switch7 = new Switch('uzo7', 'УЗО', 0)
    def switch8 = new Switch('uzo8', 'УЗО', 0)
    def switch9 = new Switch('uzo9', 'УЗО', 0)

    def kitchenLight = new Consumer("kitchenLight", "Свет на кухне", 0)
    def kitchenSocket = new Consumer("kitchenSocket", "Розетки на кухне", 0)

    def bed1Light = new Consumer("bed1Light", "Спальня 1. Свет", 0)
    def bed1Socket = new Consumer("bed1Socket", "Спальня 1. Розетки", 0)

    def bed2Light = new Consumer("bed2Light", "Спальня 2. Свет", 0)
    def bed2Socket = new Consumer("bed2Socket", "Спальня 2. Розетки", 0)

    def bed3Light = new Consumer("bed3Light", "Спальня 3. Свет", 0)
    def bed3Socket = new Consumer("bed3Socket", "Спальня 3. Розетки", 0)

    input.outputL1.connect(inputSwitch.inputL1);
    input.outputL2.connect(inputSwitch.inputL2);
    input.outputL3.connect(inputSwitch.inputL3);
    input.outputN.connect(inputSwitch.inputN);

    inputSwitch.outputL1.connect(voltageRelay1.inputL)
    inputSwitch.outputN.connect(voltageRelay1.inputN)

    inputSwitch.outputL2.connect(voltageRelay2.inputL)
    inputSwitch.outputN.connect(voltageRelay2.inputN)

    inputSwitch.outputL3.connect(voltageRelay3.inputL)
    inputSwitch.outputN.connect(voltageRelay3.inputN)

    voltageRelay1.outputL.connect(uzo1.inputL)
    voltageRelay1.outputN.connect(uzo1.inputN)

    voltageRelay2.outputL.connect(uzo2.inputL)
    voltageRelay2.outputN.connect(uzo2.inputN)

    voltageRelay3.outputL.connect(uzo3.inputL)
    voltageRelay3.outputN.connect(uzo3.inputN)


    uzo1.outputN.connect(nullBus.inputN)
    uzo1.outputL.connect(switch1.inputL)
    uzo1.outputL.connect(switch2.inputL)
    uzo1.outputL.connect(switch3.inputL)

    uzo2.outputN.connect(nullBus.inputN)
    uzo2.outputL.connect(switch4.inputL)
    uzo2.outputL.connect(switch5.inputL)
    uzo2.outputL.connect(switch6.inputL)

    uzo3.outputN.connect(nullBus.inputN)
    uzo3.outputL.connect(switch7.inputL)
    uzo3.outputL.connect(switch8.inputL)
    uzo3.outputL.connect(switch9.inputL)

    switch1.outputL.connect(kitchenLight.inputL)
    nullBus.outputN.connect(kitchenLight.inputN)
    groundBus.outputG.connect(kitchenLight.inputG)

    switch2.outputL.connect(kitchenSocket.inputL)
    nullBus.outputN.connect(kitchenSocket.inputN)
    groundBus.outputG.connect(kitchenSocket.inputG)



}
