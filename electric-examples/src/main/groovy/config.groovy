switchboard {

    name = "Simple"

    def consumers = new MyConsumers()

    Input380('input380', 'Ввод', 63, 0)

    InputSwitch4('inputSwitch', 'Вводной автомат', 64, 15)

    Uzo4('uzoFire', "УЗО 63A/100ma", 63, 300, 40)

    VoltAmperMeter('vam1', 'ВАР', 30, 20)
    VoltAmperMeter('vam2', 'ВАР', 30, 20)
    VoltAmperMeter('vam3', 'ВАР', 30, 20)

    Uzm('uzm1', 'УЗМ', 16, 20)
    Uzm('uzm2', 'УЗМ', 16, 20)
    Uzm('uzm3', 'УЗМ', 16, 20)

    Uzo('uzo1', 'УЗО 20A/30мА', 16, 10, 25)
    Uzo('uzo2', 'УЗО 20A/30мА', 16, 10, 25)
    Uzo('uzo3', 'УЗО 20A/30мА', 16, 10, 25)
    Uzo('uzo4', 'УЗО 20A/30мА', 16, 10, 25)
    Uzo('uzo5', 'УЗО 20A/30мА', 16, 10, 25)
    Uzo('uzo6', 'УЗО 20A/30мА', 16, 10, 25)
    Uzo('uzo7', 'УЗО 20A/30мА', 16, 10, 25)

    NullBus("nullBus1", "Нулевая шина 1", 0)
    NullBus("nullBus2", "Нулевая шина 2", 0)
    NullBus("nullBus3", "Нулевая шина 3", 0)
    NullBus("nullBus4", "Нулевая шина 4", 0)
    NullBus("nullBus5", "Нулевая шина 5", 0)
    NullBus("nullBus6", "Нулевая шина 6", 0)
    NullBus("nullBus7", "Нулевая шина 7", 0)

    Switch('switchKitchenLight', 'Автомат', 10, 10)
    Switch('switchKitchenSocket', 'Автомат', 16, 10)
    Switch('switchKitchenCooker', 'Автомат', 25, 10)
    Switch('switchKitchenFridge', 'Автомат', 16, 10)
    Switch('switchKitchenDishWasher', 'Автомат', 16, 10)
    Switch('switchKitchenConvector', 'Автомат', 16, 10)

    Switch('switchBed1Light', 'Автомат', 10, 10)
    Switch('switchBed1Socket', 'Автомат', 16, 10)

    Switch('switchBed2Light', 'Автомат', 10, 10)
    Switch('switchBed2Socket', 'Автомат', 16, 10)

    Switch('switchBed3Light', 'Автомат', 10, 10)
    Switch('switchBed3Socket', 'Автомат', 16, 10)

    Switch('switchLivingLight', 'Автомат', 10, 10)
    Switch('switchLivingSocket', 'Автомат', 16, 10)
    Switch('switchLivingConvector', 'Автомат', 16, 10)

    Switch('switchBathLight', 'Автомат', 10, 10)
    Switch('switchBathSocket', 'Автомат', 16, 10)
    Switch('switchBathWasher', 'Автомат', 16, 10)

    Switch('switchWcLight', 'Автомат', 10, 10)
    Switch('switchWcSocket', 'Автомат', 16, 10)

    Switch('switchWardrobeLight', 'Автомат', 10, 10)
    Switch('switchWardrobeSocket', 'Автомат', 16, 10)

    Switch('switchCorridorLight', 'Автомат', 10, 10)
    Switch('switchCorridorSocket', 'Автомат', 16, 10)

    Switch('switchBoilerLight', 'Автомат', 10, 10)
    Switch('switchBoilerSocket', 'Автомат', 16, 10)
    Switch('switchBoilerGasBoiler', 'Автомат', 25, 10)

    Switch('switchAtticLight', 'Автомат', 10, 10)
    Switch('switchAtticSocket1', 'Автомат', 16, 10)
    Switch('switchAtticSocket2', 'Автомат', 16, 10)



    input380.outputL1.connect(inputSwitch.inputL1)
    input380.outputL2.connect(inputSwitch.inputL2)
    input380.outputL3.connect(inputSwitch.inputL3)
    input380.outputN.connect(inputSwitch.inputN)

    inputSwitch.connect(uzoFire)

    uzoFire.outputL1.connect(vam1.inputL)
    uzoFire.outputN.connect(vam1.inputN)

    uzoFire.outputL2.connect(vam2.inputL)
    uzoFire.outputN.connect(vam2.inputN)

    uzoFire.outputL3.connect(vam3.inputL)
    uzoFire.outputN.connect(vam3.inputN)

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
    uzm3.connect(uzo7)

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
    uzo5.outputL.connect(switchWardrobeLight.inputL)
    uzo5.outputL.connect(switchWardrobeLight.inputL)

    uzo6.outputN.connect(nullBus6.inputN)
    uzo6.outputL.connect(switchBoilerLight.inputL)
    uzo6.outputL.connect(switchBoilerSocket.inputL)
    uzo6.outputL.connect(switchBoilerGasBoiler.inputL)

    uzo7.outputN.connect(nullBus7.inputN)
    uzo7.outputL.connect(switchAtticLight.inputL)
    uzo7.outputL.connect(switchAtticSocket1.inputL)
    uzo7.outputL.connect(switchAtticSocket2.inputL)


    outputSocket(switchKitchenLight.outputL, nullBus1.outputN).connect(consumers.kitchenLight)
    outputSocket(switchKitchenSocket.outputL, nullBus1.outputN).connect(consumers.kitchenSocket)
    outputSocket(switchKitchenCooker.outputL, nullBus1.outputN).connect(consumers.kitchenCooker)
    outputSocket(switchKitchenDishWasher.outputL, nullBus1.outputN).connect(consumers.kitchenDishWasher)
    outputSocket(switchKitchenFridge.outputL, nullBus1.outputN).connect(consumers.kitchenFridge)
    outputSocket(switchKitchenConvector.outputL, nullBus1.outputN).connect(consumers.kitchenConvector)

    outputSocket(switchBed1Light.outputL, nullBus2.outputN).connect(consumers.bed1Light)
    outputSocket(switchBed1Socket.outputL, nullBus2.outputN).connect(consumers.bed1Socket)

    outputSocket(switchBed2Light.outputL, nullBus2.outputN).connect(consumers.bed2Light)
    outputSocket(switchBed2Socket.outputL, nullBus2.outputN).connect(consumers.bed2Socket)

    outputSocket(switchBed3Light.outputL, nullBus2.outputN).connect(consumers.bed3Light)
    outputSocket(switchBed3Socket.outputL, nullBus2.outputN).connect(consumers.bed3Socket)

    outputSocket(switchLivingLight.outputL, nullBus3.outputN).connect(consumers.livingLight)
    outputSocket(switchLivingSocket.outputL, nullBus3.outputN).connect(consumers.livingSocket)
    outputSocket(switchLivingConvector.outputL, nullBus3.outputN).connect(consumers.livingConvector)

    outputSocket(switchBathLight.outputL, nullBus4.outputN).connect(consumers.bathLight)
    outputSocket(switchBathSocket.outputL, nullBus4.outputN).connect(consumers.bathSocket)
    outputSocket(switchBathWasher.outputL, nullBus4.outputN).connect(consumers.bathWasher)

    outputSocket(switchCorridorLight.outputL, nullBus5.outputN).connect(consumers.corridorLight)
    outputSocket(switchCorridorSocket.outputL, nullBus5.outputN).connect(consumers.corridorSocket)
    outputSocket(switchWardrobeLight.outputL, nullBus5.outputN).connect(consumers.wardrobeLight)
    outputSocket(switchWardrobeSocket.outputL, nullBus5.outputN).connect(consumers.wardrobeSocket)
    outputSocket(switchWcLight.outputL, nullBus5.outputN).connect(consumers.wcLight)
    outputSocket(switchWcSocket.outputL, nullBus5.outputN).connect(consumers.wcSocket)

    outputSocket(switchBoilerLight.outputL, nullBus6.outputN).connect(consumers.boilerLight)
    outputSocket(switchBoilerSocket.outputL, nullBus6.outputN).connect(consumers.boilerSocket)
    outputSocket(switchBoilerGasBoiler.outputL, nullBus6.outputN).connect(consumers.boilerGasBoiler)

    outputSocket(switchAtticLight.outputL, nullBus7.outputN).connect(consumers.atticLight)
    outputSocket(switchAtticSocket1.outputL, nullBus7.outputN).connect(consumers.atticSocket1)
    outputSocket(switchAtticSocket2.outputL, nullBus7.outputN).connect(consumers.atticSocket2)

}

