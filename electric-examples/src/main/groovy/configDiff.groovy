

import com.anton.electric.model.*
import com.anton.electric.model.impl.*

switchboard {

    Input380 input = root(new Input380('input380', 'Ввод', 63, 0))

    def inputSwitch = new InputSwitch4('inputSwitch', 'Вводной автомат', 64, 15)

    def vam1 = new VoltAmperMeter('vam1', 'ВАР', 30, 20)
    def vam2 = new VoltAmperMeter('vam2', 'ВАР', 30, 20)
    def vam3 = new VoltAmperMeter('vam3', 'ВАР', 30, 20)

    def uzm1 = new Uzm('uzm1', 'УЗМ', 16, 20)
    def uzm2 = new Uzm('uzm2', 'УЗМ', 16, 20)
    def uzm3 = new Uzm('uzm3', 'УЗМ', 16, 20)

    def uzo1 = new Uzo('uzo1', 'УЗО', 16, 25)
    def uzo2 = new Uzo('uzo2', 'УЗО', 16, 25)
    def uzo3 = new Uzo('uzo3', 'УЗО', 16, 25)

    def nullBus1 = new NullBus("null1", "Нулевая шина 1", 0)
    def nullBus2 = new NullBus("null2", "Нулевая шина 2", 0)
    def nullBus3 = new NullBus("null3", "Нулевая шина 3", 0)

    def switchKitchenLight = new Switch('switchKitchenLight', 'Автомат 16A', 16, 10)
    def switchKitchenSocket = new Switch('switchKitchenSocket', 'Автомат 16A', 16, 10)
    def switchKitchenCooker = new Switch('switchKitchenCooker', 'Автомат 16A', 16, 10)
    def switchKitchenFridge = new Switch('switchKitchenFridge', 'Автомат 16A', 16, 10)
    def switchKitchenDishWasher = new Switch('switchKitchenDishWasher', 'Автомат 16A', 16, 10)

    def switchBed1Light = new Switch('switchBed1Light', 'Автомат 16A', 16, 10)
    def switchBed1Socket = new Switch('switchBed1Socket', 'Автомат 16A', 16, 10)

    def switchBed2Light = new Switch('switchBed2Light', 'Автомат 16A', 16, 10)
    def switchBed2Socket = new Switch('switchBed2Socket', 'Автомат 16A', 16, 10)

    def switchBed3Light = new Switch('switchBed3Light', 'Автомат 16A', 16, 10)
    def switchBed3Socket = new Switch('switchBed3Socket', 'Автомат 16A', 16, 10)

    def switchLivingLight = new Switch('switchLivingLight', 'Автомат 16A', 16, 10)
    def switchLivingSocket = new Switch('switchLivingSocket', 'Автомат 16A', 16, 10)


    def kitchenLight = new Consumer("kitchenLight", "Кухня. Свет.", 16, 0)
    def kitchenSocket = new Consumer("kitchenSocket", "Кухня. Розетки.", 16, 0)
    def kitchenCooker = new Consumer("kitchenCooker", "Кухня. Электроплита.", 16, 0)
    def kitchenDishWasher = new Consumer("kitchenDishWasher", "Кухня. Посудомойка.", 16, 0)
    def kitchenFridge = new Consumer("kitchenFridge", "Кухня. Холодильник.", 16, 0)

    def bed1Light = new Consumer("bed1Light", "Спальня 1. Свет", 16, 0)
    def bed1Socket = new Consumer("bed1Socket", "Спальня 1. Розетки", 16, 0)

    def bed2Light = new Consumer("bed2Light", "Спальня 2. Свет", 16, 0)
    def bed2Socket = new Consumer("bed2Socket", "Спальня 2. Розетки", 16, 0)

    def bed3Light = new Consumer("bed3Light", "Спальня 3. Свет", 16, 0)
    def bed3Socket = new Consumer("bed3Socket", "Спальня 3. Розетки", 16, 0)

    def livingLight = new Consumer("livingLight", "Гостиная. Свет", 16, 0)
    def livingSocket = new Consumer("livingSocket", "Гостиная. Розетки", 16, 0)

    input.outputL1.connect(inputSwitch.inputL1)
    input.outputL2.connect(inputSwitch.inputL2)
    input.outputL3.connect(inputSwitch.inputL3)
    input.outputN.connect(inputSwitch.inputN)


    inputSwitch.outputL1.connect(vam1.inputL)
    inputSwitch.outputN.connect(vam1.inputN)

    inputSwitch.outputL2.connect(vam2.inputL)
    inputSwitch.outputN.connect(vam2.inputN)

    inputSwitch.outputL3.connect(vam3.inputL)
    inputSwitch.outputN.connect(vam3.inputN)

    vam1.connect(uzm1)
    vam2.connect(uzm2)
    vam3.connect(uzm3)

    uzm1.connect(uzo1)
    uzm2.connect(uzo2)
    uzm3.connect(uzo3)

    uzo1.outputN.connect(nullBus1.inputN)
    uzo1.outputL.connect(switchKitchenLight.inputL)
    uzo1.outputL.connect(switchKitchenSocket.inputL)
    uzo1.outputL.connect(switchKitchenCooker.inputL)
    uzo1.outputL.connect(switchKitchenFridge.inputL)
    uzo1.outputL.connect(switchKitchenDishWasher.inputL)

    uzo2.outputN.connect(nullBus2.inputN)
    uzo2.outputL.connect(switchBed1Light.inputL)
    uzo2.outputL.connect(switchBed1Socket.inputL)
    uzo2.outputL.connect(switchBed2Light.inputL)
    uzo2.outputL.connect(switchBed2Socket.inputL)
    uzo2.outputL.connect(switchBed3Light.inputL)
    uzo2.outputL.connect(switchBed3Socket.inputL)

    uzo3.outputN.connect(nullBus3.inputN)
    uzo3.outputL.connect(switchLivingLight.inputL)
    uzo3.outputL.connect(switchLivingSocket.inputL)


    outputSocket(switchKitchenLight.outputL, nullBus1.outputN).connect(kitchenLight)
    outputSocket(switchKitchenSocket.outputL, nullBus1.outputN).connect(kitchenSocket)
    outputSocket(switchKitchenCooker.outputL, nullBus1.outputN).connect(kitchenCooker)
    outputSocket(switchKitchenDishWasher.outputL, nullBus1.outputN).connect(kitchenDishWasher)
    outputSocket(switchKitchenFridge.outputL, nullBus1.outputN).connect(kitchenFridge)

    outputSocket(switchBed1Light.outputL, nullBus2.outputN).connect(bed1Light)
    outputSocket(switchBed1Socket.outputL, nullBus2.outputN).connect(bed1Socket)

    outputSocket(switchBed2Light.outputL, nullBus2.outputN).connect(bed2Light)
    outputSocket(switchBed2Socket.outputL, nullBus2.outputN).connect(bed2Socket)

    outputSocket(switchBed3Light.outputL, nullBus2.outputN).connect(bed3Light)
    outputSocket(switchBed3Socket.outputL, nullBus2.outputN).connect(bed3Socket)

    outputSocket(switchLivingLight.outputL, nullBus3.outputN).connect(livingLight)
    outputSocket(switchLivingSocket.outputL, nullBus3.outputN).connect(livingSocket)

}

