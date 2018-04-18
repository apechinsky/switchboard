import com.anton.electric.model.Consumer
import com.anton.electric.model.impl.*

switchboard {

    Input380 input = root(new Input380('input380', 'Ввод', 0))

    def inputSwitch = new InputSwitch('inputSwitch', 'Вводной автомат', 15)

    def voltageRelay2 = new VoltageRelay('voltageRelay2', 'Реле напряжения', 20)
    def voltageRelay1 = new VoltageRelay('voltageRelay1', 'Реле напряжения', 20)
    def voltageRelay3 = new VoltageRelay('voltageRelay3', 'Реле напряжения', 20)

    def uzo1 = new Uzo('uzo1', 'УЗО', 25)
    def uzo2 = new Uzo('uzo2', 'УЗО', 25)
    def uzo3 = new Uzo('uzo3', 'УЗО', 25)
    def uzo4 = new Uzo('uzo4', 'УЗО', 25)
    def uzo5 = new Uzo('uzo5', 'УЗО', 25)
    def uzo6 = new Uzo('uzo6', 'УЗО', 25)
    def uzo7 = new Uzo('uzo7', 'УЗО', 25)

    def switchKitchenLight = new Switch('switchKitchenLight', 'Автомат 16A', 10)
    def switchKitchenSocket = new Switch('switchKitchenSocket', 'Автомат 16A', 10)
    def switchKitchenCooker = new Switch('switchKitchenCooker', 'Автомат 16A', 10)
    def switchKitchenFridge = new Switch('switchKitchenFridge', 'Автомат 16A', 10)
    def switchKitchenDishWasher = new Switch('switchKitchenDishWasher', 'Автомат 16A', 10)

    def switchBed1Light = new Switch('switchBed1Light', 'Автомат 16A', 10)
    def switchBed1Socket = new Switch('switchBed1Socket', 'Автомат 16A', 10)

    def switchBed2Light = new Switch('switchBed2Light', 'Автомат 16A', 10)
    def switchBed2Socket = new Switch('switchBed2Socket', 'Автомат 16A', 10)

    def switchBed3Light = new Switch('switchBed3Light', 'Автомат 16A', 10)
    def switchBed3Socket = new Switch('switchBed3Socket', 'Автомат 16A', 10)

    def switchLivingLight = new Switch('switchLivingLight', 'Автомат 16A', 10)
    def switchLivingSocket = new Switch('switchLivingSocket', 'Автомат 16A', 10)


    def kitchenLight = new Consumer("kitchenLight", "Кухня. Свет.", 0)
    def kitchenSocket = new Consumer("kitchenSocket", "Кухня. Розетки.", 0)
    def kitchenCooker = new Consumer("kitchenCooker", "Кухня. Электроплита.", 0)
    def kitchenDishWasher = new Consumer("kitchenDishWasher", "Кухня. Посудомойка.", 0)
    def kitchenFridge = new Consumer("kitchenFridge", "Кухня. Холодильник.", 0)

    def bed1Light = new Consumer("bed1Light", "Спальня 1. Свет", 0)
    def bed1Socket = new Consumer("bed1Socket", "Спальня 1. Розетки", 0)

    def bed2Light = new Consumer("bed2Light", "Спальня 2. Свет", 0)
    def bed2Socket = new Consumer("bed2Socket", "Спальня 2. Розетки", 0)

    def bed3Light = new Consumer("bed3Light", "Спальня 3. Свет", 0)
    def bed3Socket = new Consumer("bed3Socket", "Спальня 3. Розетки", 0)

    def livingLight = new Consumer("livingLight", "Гостиная. Свет", 0)
    def livingSocket = new Consumer("livingSocket", "Гостиная. Розетки", 0)

    input.outputL1.connect(inputSwitch.inputL1)
    input.outputL2.connect(inputSwitch.inputL2)
    input.outputL3.connect(inputSwitch.inputL3)
    input.outputN.connect(inputSwitch.inputN)

    inputSwitch.outputL1.connect(voltageRelay1.inputL)
    inputSwitch.outputN.connect(voltageRelay1.inputN)

    inputSwitch.outputL2.connect(voltageRelay2.inputL)
    inputSwitch.outputN.connect(voltageRelay2.inputN)

    inputSwitch.outputL3.connect(voltageRelay3.inputL)
    inputSwitch.outputN.connect(voltageRelay3.inputN)

    voltageRelay1.connect(uzo1)
    voltageRelay2.connect(uzo1)
    voltageRelay2.connect(uzo1)


    uzo1.outputN.connect(nullBus.inputN)
    uzo1.outputL.connect(switchKitchenLight.inputL)
    uzo1.outputL.connect(switchKitchenSocket.inputL)
    uzo1.outputL.connect(switchKitchenCooker.inputL)
    uzo1.outputL.connect(switchKitchenFridge.inputL)
    uzo1.outputL.connect(switchKitchenDishWasher.inputL)

    uzo2.outputN.connect(nullBus.inputN)
    uzo2.outputL.connect(switchBed1Light.inputL)
    uzo2.outputL.connect(switchBed1Socket.inputL)
    uzo2.outputL.connect(switchBed2Light.inputL)
    uzo2.outputL.connect(switchBed2Socket.inputL)
    uzo2.outputL.connect(switchBed3Light.inputL)
    uzo2.outputL.connect(switchBed3Socket.inputL)

    uzo3.outputN.connect(nullBus.inputN)
    uzo3.outputL.connect(switchLivingLight.inputL)
    uzo3.outputL.connect(switchLivingSocket.inputL)

    outputSocket(switchKitchenLight.outputL).connect(kitchenLight)
    outputSocket(switchKitchenSocket.outputL).connect(kitchenSocket)
    outputSocket(switchKitchenCooker.outputL).connect(kitchenCooker)
    outputSocket(switchKitchenFridge.outputL).connect(kitchenFridge)
    outputSocket(switchKitchenDishWasher.outputL).connect(kitchenDishWasher)

    outputSocket(switchBed1Light.outputL).connect(bed1Light)
    outputSocket(switchBed1Socket.outputL).connect(bed1Socket)
    outputSocket(switchBed2Light.outputL).connect(bed2Light)
    outputSocket(switchBed2Socket.outputL).connect(bed2Socket)
    outputSocket(switchBed3Light.outputL).connect(bed3Light)
    outputSocket(switchBed3Socket.outputL).connect(bed3Socket)

    outputSocket(switchLivingLight.outputL).connect(livingLight)
    outputSocket(switchLivingSocket.outputL).connect(livingSocket)

}
