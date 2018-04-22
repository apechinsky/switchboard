package com.anton.electric.render

import com.anton.electric.model.*
import com.anton.electric.model.impl.*

switchboard {

    Input380 input380 = root(new Input380('input380', 'Ввод', 0))

    def inputSwitch = new InputSwitch4('inputSwitch', 'Вводной автомат', 15)

    def vam1 = new VoltAmperMeter('vam1', 'ВАР', 20)
    def vam2 = new VoltAmperMeter('vam2', 'ВАР', 20)
    def vam3 = new VoltAmperMeter('vam3', 'ВАР', 20)

    def uzm1 = new Uzm('uzm1', 'УЗМ', 20)
    def uzm2 = new Uzm('uzm2', 'УЗМ', 20)
    def uzm3 = new Uzm('uzm3', 'УЗМ', 20)

    def uzo1 = new Uzo('uzo1', 'УЗО', 25)
    def uzo2 = new Uzo('uzo2', 'УЗО', 25)
    def uzo3 = new Uzo('uzo3', 'УЗО', 25)
    def uzo4 = new Uzo('uzo4', 'УЗО', 25)
    def uzo5 = new Uzo('uzo5', 'УЗО', 25)
    def uzo6 = new Uzo('uzo6', 'УЗО', 25)

    def nullBus1 = new NullBus("null1", "Нулевая шина 1", 0)
    def nullBus2 = new NullBus("null2", "Нулевая шина 2", 0)
    def nullBus3 = new NullBus("null3", "Нулевая шина 3", 0)
    def nullBus4 = new NullBus("null4", "Нулевая шина 4", 0)
    def nullBus5 = new NullBus("null5", "Нулевая шина 5", 0)
    def nullBus6 = new NullBus("null6", "Нулевая шина 5", 0)

    def switchKitchenLight = new Switch('switchKitchenLight', 'Автомат 16A', 10)
    def switchKitchenSocket = new Switch('switchKitchenSocket', 'Автомат 16A', 10)
    def switchKitchenCooker = new Switch('switchKitchenCooker', 'Автомат 16A', 10)
    def switchKitchenFridge = new Switch('switchKitchenFridge', 'Автомат 16A', 10)
    def switchKitchenDishWasher = new Switch('switchKitchenDishWasher', 'Автомат 16A', 10)
    def switchKitchenConvector = new Switch('switchKitchenConvector', 'Автомат 16A', 10)

    def switchBed1Light = new Switch('switchBed1Light', 'Автомат 16A', 10)
    def switchBed1Socket = new Switch('switchBed1Socket', 'Автомат 16A', 10)

    def switchBed2Light = new Switch('switchBed2Light', 'Автомат 16A', 10)
    def switchBed2Socket = new Switch('switchBed2Socket', 'Автомат 16A', 10)

    def switchBed3Light = new Switch('switchBed3Light', 'Автомат 16A', 10)
    def switchBed3Socket = new Switch('switchBed3Socket', 'Автомат 16A', 10)

    def switchLivingLight = new Switch('switchLivingLight', 'Автомат 16A', 10)
    def switchLivingSocket = new Switch('switchLivingSocket', 'Автомат 16A', 10)
    def switchLivingConvector = new Switch('switchLivingConvector', 'Автомат 16A', 10)

    def switchBathLight = new Switch('switchBathLight', 'Автомат 16A', 10)
    def switchBathSocket = new Switch('switchBathSocket', 'Автомат 16A', 10)
    def switchBathWasher = new Switch('switchBathWasher', 'Автомат 16A', 10)

    def switchWcLight = new Switch('switchWcLight', 'Автомат 16A', 10)
    def switchWcSocket = new Switch('switchWcSocket', 'Автомат 16A', 10)

    def switchWadrobeLight = new Switch('switchWadrobeLight', 'Автомат 16A', 10)
    def switchWadrobeSocket = new Switch('switchWadrobeSocket', 'Автомат 16A', 10)

    def switchCorridorLight = new Switch('switchCorridorLight', 'Автомат 16A', 10)
    def switchCorridorSocket = new Switch('switchCorridorSocket', 'Автомат 16A', 10)

    def switchBoilerLight = new Switch('switchBoilerLight', 'Автомат 16A', 10)
    def switchBoilerSocket = new Switch('switchBoilerSocket', 'Автомат 16A', 10)
    def switchBoilerGasBoiler = new Switch('switchBoilerGasBoiler', 'Автомат 16A', 10)



    def kitchenLight = new Consumer("kitchenLight", "Кухня. Свет.", 0)
    def kitchenSocket = new Consumer("kitchenSocket", "Кухня. Розетки.", 0)
    def kitchenCooker = new Consumer("kitchenCooker", "Кухня. Электроплита.", 0)
    def kitchenFridge = new Consumer("kitchenFridge", "Кухня. Холодильник.", 0)
    def kitchenDishWasher = new Consumer("kitchenDishWasher", "Кухня. Посудомойка.", 0)
    def kitchenConvector = new Consumer("kitchenConvector", "Кухня. Конвектор.", 0)

    def bed1Light = new Consumer("bed1Light", "Спальня 1. Свет", 0)
    def bed1Socket = new Consumer("bed1Socket", "Спальня 1. Розетки", 0)

    def bed2Light = new Consumer("bed2Light", "Спальня 2. Свет", 0)
    def bed2Socket = new Consumer("bed2Socket", "Спальня 2. Розетки", 0)

    def bed3Light = new Consumer("bed3Light", "Спальня 3. Свет", 0)
    def bed3Socket = new Consumer("bed3Socket", "Спальня 3. Розетки", 0)

    def livingLight = new Consumer("livingLight", "Гостиная. Свет", 0)
    def livingSocket = new Consumer("livingSocket", "Гостиная. Розетки", 0)
    def livingConvector = new Consumer("livingConvector", "Гостиная. Конвекторы", 0)

    def bathLight = new Consumer("bathLight", "Ванная. Свет", 0)
    def bathSocket = new Consumer("bathSocket", "Ванная. Розетки", 0)
    def bathWasher = new Consumer("bathWasher", "Ванная. Стиральная машина", 0)

    def wcLight = new Consumer("wcLight", "Туалет. Свет", 0)
    def wcSocket = new Consumer("wcSocket", "Туалет. Вывод", 0)

    def wardrobeLight = new Consumer("wardrobeLight", "Гардероб. Свет", 0)
    def wardrobeSocket = new Consumer("wardrobeSocket", "Гардероб. Розетки", 0)

    def corridorLight = new Consumer("corridorLight", "Коридор. Свет", 0)
    def corridorSocket = new Consumer("corridorSocket", "Коридор. Розетки", 0)

    def boilerLight = new Consumer("boilerLight", "Топочная. Свет", 0)
    def boilerSocket = new Consumer("boilerSocket", "Топочная. Розетки", 0)
    def boilerGasBoiler = new Consumer("boilerGasBoiler", "Топочная. Котел", 0)

    input380.outputL1.connect(inputSwitch.inputL1)
    input380.outputL2.connect(inputSwitch.inputL2)
    input380.outputL3.connect(inputSwitch.inputL3)
    input380.outputN.connect(inputSwitch.inputN)


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
    uzm1.connect(uzo2)
    uzm2.connect(uzo3)
    uzm2.connect(uzo3)
    uzm3.connect(uzo4)
    uzm3.connect(uzo5)
    uzm3.connect(uzo6)

    uzo1.outputN.connect(nullBus1.inputN)
    uzo1.outputL.connect(switchKitchenLight.inputL)
    uzo1.outputL.connect(switchKitchenSocket.inputL)
    uzo1.outputL.connect(switchKitchenCooker.inputL)
    uzo1.outputL.connect(switchKitchenFridge.inputL)
    uzo1.outputL.connect(switchKitchenDishWasher.inputL)
    uzo1.outputL.connect(switchKitchenConvector.inputL)

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
    uzo3.outputL.connect(switchLivingConvector.inputL)

    uzo4.outputN.connect(nullBus4.inputN)
    uzo4.outputL.connect(switchBathLight.inputL)
    uzo4.outputL.connect(switchBathSocket.inputL)
    uzo4.outputL.connect(switchBathWasher.inputL)

    uzo5.outputN.connect(nullBus5.inputN)
    uzo5.outputL.connect(switchCorridorLight.inputL)
    uzo5.outputL.connect(switchCorridorSocket.inputL)
    uzo5.outputL.connect(switchWcLight.inputL)
    uzo5.outputL.connect(switchWcSocket.inputL)
    uzo5.outputL.connect(switchWadrobeLight.inputL)
    uzo5.outputL.connect(switchWadrobeLight.inputL)

    uzo6.outputL.connect(switchBoilerLight.inputL)
    uzo6.outputL.connect(switchBoilerSocket.inputL)
    uzo6.outputL.connect(switchBoilerGasBoiler.inputL)


    outputSocket(switchKitchenLight.outputL, nullBus1.outputN).connect(kitchenLight)
    outputSocket(switchKitchenSocket.outputL, nullBus1.outputN).connect(kitchenSocket)
    outputSocket(switchKitchenCooker.outputL, nullBus1.outputN).connect(kitchenCooker)
    outputSocket(switchKitchenDishWasher.outputL, nullBus1.outputN).connect(kitchenDishWasher)
    outputSocket(switchKitchenFridge.outputL, nullBus1.outputN).connect(kitchenFridge)
    outputSocket(switchKitchenConvector.outputL, nullBus1.outputN).connect(kitchenConvector)

    outputSocket(switchBed1Light.outputL, nullBus2.outputN).connect(bed1Light)
    outputSocket(switchBed1Socket.outputL, nullBus2.outputN).connect(bed1Socket)

    outputSocket(switchBed2Light.outputL, nullBus2.outputN).connect(bed2Light)
    outputSocket(switchBed2Socket.outputL, nullBus2.outputN).connect(bed2Socket)

    outputSocket(switchBed3Light.outputL, nullBus2.outputN).connect(bed3Light)
    outputSocket(switchBed3Socket.outputL, nullBus2.outputN).connect(bed3Socket)

    outputSocket(switchLivingLight.outputL, nullBus3.outputN).connect(livingLight)
    outputSocket(switchLivingSocket.outputL, nullBus3.outputN).connect(livingSocket)
    outputSocket(switchLivingConvector.outputL, nullBus3.outputN).connect(livingConvector)

    outputSocket(switchBathLight.outputL, nullBus4.outputN).connect(bathLight)
    outputSocket(switchBathSocket.outputL, nullBus4.outputN).connect(bathSocket)
    outputSocket(switchBathWasher.outputL, nullBus4.outputN).connect(bathWasher)

    outputSocket(switchCorridorLight.outputL, nullBus5.outputN).connect(corridorLight)
    outputSocket(switchCorridorSocket.outputL, nullBus5.outputN).connect(corridorSocket)
    outputSocket(switchWadrobeLight.outputL, nullBus5.outputN).connect(wardrobeLight)
    outputSocket(switchWadrobeSocket.outputL, nullBus5.outputN).connect(wardrobeSocket)
    outputSocket(switchWcLight.outputL, nullBus5.outputN).connect(wcLight)
    outputSocket(switchWcSocket.outputL, nullBus5.outputN).connect(wcSocket)

    outputSocket(switchBoilerLight.outputL, nullBus6.outputN).connect(boilerLight)
    outputSocket(switchBoilerSocket.outputL, nullBus6.outputN).connect(boilerSocket)
    outputSocket(switchBoilerGasBoiler.outputL, nullBus6.outputN).connect(boilerGasBoiler)

}

