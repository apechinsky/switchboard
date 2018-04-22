#!/usr/bin/env groovy
import com.anton.electric.dsl.SwitchboardBuilder
import com.anton.electric.model.Consumer
import com.anton.electric.model.Switchboard
import com.anton.electric.model.impl.*


def builder = new SwitchboardBuilder()

Switchboard switchboard = builder.switchboard {

    Input380 input = root(new Input380('input380', 'Ввод', 0))

    def inputSwitch = new InputSwitch('inputSwitch', 'Вводной автомат', 15)

    def uzm1 = new Uzm('uzm1', 'Реле напряжения', 20)
    def uzm2 = new Uzm('uzm2', 'Реле напряжения', 20)
    def uzm3 = new Uzm('uzm3', 'Реле напряжения', 20)

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

    inputSwitch.outputL1.connect(uzm1.inputL)
    inputSwitch.outputN.connect(uzm1.inputN)

    inputSwitch.outputL2.connect(uzm2.inputL)
    inputSwitch.outputN.connect(uzm2.inputN)

    inputSwitch.outputL3.connect(uzm3.inputL)
    inputSwitch.outputN.connect(uzm3.inputN)

    uzm1.outputL.connect(uzo1.inputL)
    uzm1.outputN.connect(uzo1.inputN)

    uzm2.outputL.connect(uzo2.inputL)
    uzm2.outputN.connect(uzo2.inputN)

    uzm3.outputL.connect(uzo3.inputL)
    uzm3.outputN.connect(uzo3.inputN)


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


    switchKitchenLight.outputL.connect(kitchenLight.inputL)
    nullBus.outputN.connect(kitchenLight.inputN)
    groundBus.outputG.connect(kitchenLight.inputG)

    switchKitchenSocket.outputL.connect(kitchenSocket.inputL)
    nullBus.outputN.connect(kitchenSocket.inputN)
    groundBus.outputG.connect(kitchenSocket.inputG)

    switchKitchenCooker.outputL.connect(kitchenCooker.inputL)
    nullBus.outputN.connect(kitchenCooker.inputN)
    groundBus.outputG.connect(kitchenCooker.inputG)

    switchKitchenFridge.outputL.connect(kitchenFridge.inputL)
    nullBus.outputN.connect(kitchenCooker.inputN)
    groundBus.outputG.connect(kitchenCooker.inputG)

    switchKitchenDishWasher.outputL.connect(kitchenDishWasher.inputL)
    nullBus.outputN.connect(kitchenCooker.inputN)
    groundBus.outputG.connect(kitchenCooker.inputG)


    switchBed1Light.outputL.connect(bed1Light.inputL)
    nullBus.outputN.connect(bed1Light.inputN)
    groundBus.outputG.connect(bed1Light.inputG)

    switchBed1Socket.outputL.connect(bed1Socket.inputL)
    nullBus.outputN.connect(bed1Socket.inputN)
    groundBus.outputG.connect(bed1Socket.inputG)

    switchBed2Light.outputL.connect(bed2Light.inputL)
    nullBus.outputN.connect(bed2Light.inputN)
    groundBus.outputG.connect(bed2Light.inputG)

    switchBed2Socket.outputL.connect(bed2Socket.inputL)
    nullBus.outputN.connect(bed2Socket.inputN)
    groundBus.outputG.connect(bed2Socket.inputG)

    switchBed3Light.outputL.connect(bed3Light.inputL)
    nullBus.outputN.connect(bed3Light.inputN)
    groundBus.outputG.connect(bed3Light.inputG)

    switchBed2Socket.outputL.connect(bed3Socket.inputL)
    nullBus.outputN.connect(bed3Socket.inputN)
    groundBus.outputG.connect(bed3Socket.inputG)


    switchLivingLight.outputL.connect(livingLight.inputL)
    nullBus.outputN.connect(bed2Light.inputN)
    groundBus.outputG.connect(bed2Light.inputG)

    switchLivingSocket.outputL.connect(livingSocket.inputL)
    nullBus.outputN.connect(bed2Socket.inputN)
    groundBus.outputG.connect(bed2Socket.inputG)

}

println switchboard
