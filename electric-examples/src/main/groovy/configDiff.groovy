
switchboard {

    name = "Diff"

    def consumers = new MyConsumers()

    Input380('input380', 'Вводная линия', 63, 0)

    Input380('generator', 'Генератор трехфазный', 63, 0)

    ReverseSwitch('reverseSwitch', 'Реверсивный рубильник', 100, 0)

    InputSwitch4('inputSwitch', 'Вводной автомат', 64, 15)

    Uzo4('uzoFire', "УЗО противопожарное", 63, 300, 40)

    VoltAmperMeter('vam1', 'ВАР-М01-08', 63, 20)
    VoltAmperMeter('vam2', 'ВАР-М01-08', 63, 20)
    VoltAmperMeter('vam3', 'ВАР-М01-08', 63, 20)

    Uzm('uzm1', 'УЗМ-51м', 63, 20)
    Uzm('uzm2', 'УЗМ-51м', 63, 20)
    Uzm('uzm3', 'УЗМ-51м', 63, 20)

    CrossBus("crossBusPersistent", "Кросс модуль. Неотключаемые", 100, 5, 25)

    Switch4("manualSwitch", "Рубильник", 100, 20)

    CrossBus("crossBus", "Кросс модуль", 100, 10, 25)

    Diff('diffWeakSwitchboard', 'Дифавтомат', 10, 10, 30)

    Diff('diffKitchenLight', 'Дифавтомат', 10, 10, 30)
    Diff('diffKitchenSocket', 'Дифавтомат', 16, 10, 30)
    Diff('diffKitchenCooker', 'Дифавтомат', 25, 10, 30)
    Diff('diffKitchenFridge', 'Дифавтомат', 16, 10, 30)
    Diff('diffKitchenDishWasher', 'Дифавтомат', 16, 10, 30)
    Diff('diffKitchenConvector', 'Дифавтомат', 16, 10, 30)

    Diff('diffBed1Light', 'Дифавтомат', 10, 10, 30)
    Diff('diffBed1Socket', 'Дифавтомат', 16, 10, 30)

    Diff('diffBed2Light', 'Дифавтомат', 10, 10, 30)
    Diff('diffBed2Socket', 'Дифавтомат', 16, 10, 30)

    Diff('diffBed3Light', 'Дифавтомат', 10, 10, 30)
    Diff('diffBed3Socket', 'Дифавтомат', 16, 10, 30)

    Diff('diffLivingLight', 'Дифавтомат', 10, 10, 30)
    Diff('diffLivingSocket', 'Дифавтомат', 16, 10, 30)
    Diff('diffLivingConvector', 'Дифавтомат', 16, 10, 30)

    Diff('diffBathLight', 'Дифавтомат', 10, 10, 30)
    Diff('diffBathSocket', 'Дифавтомат', 16, 10, 30)
    Diff('diffBathWasher', 'Дифавтомат', 16, 10, 30)

    Diff('diffWcLight', 'Дифавтомат', 10, 10, 30)
    Diff('diffWcSocket', 'Дифавтомат', 16, 10, 30)

    Diff('diffWardrobeLight', 'Дифавтомат', 10, 10, 30)
    Diff('diffWardrobeSocket', 'Дифавтомат', 16, 10, 30)

    Diff('diffCorridorLight', 'Дифавтомат', 10, 10, 30)
    Diff('diffCorridorSocket', 'Дифавтомат', 16, 10, 30)

    Diff('diffBoilerLight', 'Дифавтомат', 10, 10, 30)
    Diff('diffBoilerSocket', 'Дифавтомат', 16, 10, 30)
    Diff('diffBoilerGasBoiler', 'Дифавтомат', 25, 10, 30)

    Diff('diffAtticLight', 'Дифавтомат', 10, 10, 30)
    Diff('diffAtticSocket1', 'Дифавтомат', 16, 10, 30)
    Diff('diffAtticSocket2', 'Дифавтомат', 16, 10, 30)

    input380.outputL1.connect(reverseSwitch.inputL1_1)
    input380.outputL2.connect(reverseSwitch.inputL2_1)
    input380.outputL3.connect(reverseSwitch.inputL3_1)

    generator.outputL1.connect(reverseSwitch.inputL1_2)
    generator.outputL2.connect(reverseSwitch.inputL2_2)
    generator.outputL3.connect(reverseSwitch.inputL3_2)

    reverseSwitch.outputL1.connect(inputSwitch.inputL1)
    reverseSwitch.outputL2.connect(inputSwitch.inputL2)
    reverseSwitch.outputL3.connect(inputSwitch.inputL3)

    input380.outputN.connect(inputSwitch.inputN)

    inputSwitch.connect(uzoFire)

    uzoFire.outputL1.connect(vam1.inputL)
    uzoFire.outputN.connect(vam1.inputN)

    uzoFire.outputL2.connect(vam2.inputL)
    uzoFire.outputN.connect(vam2.inputN)

    uzoFire.outputL3.connect(vam3.inputL)
    uzoFire.outputN.connect(vam3.inputN)

    uzoFire.outputN.connect(crossBusPersistent.inputN)

    vam1.connect(uzm1)
    vam2.connect(uzm2)
    vam3.connect(uzm3)

    uzm1.outputL.connect(crossBusPersistent.inputL1)
    uzm2.outputL.connect(crossBusPersistent.inputL2)
    uzm3.outputL.connect(crossBusPersistent.inputL3)

    uzm1.outputL.connect(manualSwitch.inputL1)
    uzm2.outputL.connect(manualSwitch.inputL2)
    uzm3.outputL.connect(manualSwitch.inputL3)
    uzoFire.outputN.connect(manualSwitch.inputN)

    manualSwitch.outputL1.connect(crossBus.inputL1)
    manualSwitch.outputL2.connect(crossBus.inputL2)
    manualSwitch.outputL3.connect(crossBus.inputL3)
    manualSwitch.outputN.connect(crossBus.inputN)

    crossBusPersistent.connectL1(diffWeakSwitchboard)

    crossBus.connectL1(diffKitchenLight)
    crossBus.connectL1(diffKitchenSocket)
    crossBus.connectL1(diffKitchenCooker)
    crossBus.connectL1(diffKitchenDishWasher)
    crossBusPersistent.connectL1(diffKitchenFridge)
    crossBus.connectL1(diffKitchenConvector)

    crossBus.connectL1(diffBed1Light)
    crossBus.connectL1(diffBed1Socket)
    crossBus.connectL1(diffBed2Light)
    crossBus.connectL1(diffBed2Socket)
    crossBus.connectL1(diffBed3Light)
    crossBus.connectL1(diffBed3Socket)

    crossBus.connectL1(diffLivingLight)
    crossBus.connectL1(diffLivingSocket)
    crossBus.connectL1(diffLivingConvector)

    crossBus.connectL2(diffBathLight)
    crossBus.connectL2(diffBathSocket)
    crossBus.connectL2(diffBathWasher)

    crossBusPersistent.connectL2(diffCorridorLight)
    crossBus.connectL2(diffCorridorSocket)
    crossBus.connectL2(diffWcLight)
    crossBus.connectL2(diffWcSocket)
    crossBus.connectL2(diffWardrobeLight)
    crossBus.connectL2(diffWardrobeLight)

    crossBus.connectL3(diffBoilerLight)
    crossBus.connectL3(diffBoilerSocket)
    crossBus.connectL3(diffBoilerGasBoiler)

    outputSocket(diffWeakSwitchboard).connect(consumers.weakSwitchboard)

    outputSocket(diffKitchenLight).connect(consumers.kitchenLight)
    outputSocket(diffKitchenSocket).connect(consumers.kitchenSocket)
    outputSocket(diffKitchenCooker).connect(consumers.kitchenCooker)
    outputSocket(diffKitchenDishWasher).connect(consumers.kitchenDishWasher)
    outputSocket(diffKitchenFridge).connect(consumers.kitchenFridge)
    outputSocket(diffKitchenConvector).connect(consumers.kitchenConvector)

    outputSocket(diffBed1Light).connect(consumers.bed1Light)
    outputSocket(diffBed1Socket).connect(consumers.bed1Socket)

    outputSocket(diffBed2Light).connect(consumers.bed2Light)
    outputSocket(diffBed2Socket).connect(consumers.bed2Socket)

    outputSocket(diffBed3Light).connect(consumers.bed3Light)
    outputSocket(diffBed3Socket).connect(consumers.bed3Socket)

    outputSocket(diffLivingLight).connect(consumers.livingLight)
    outputSocket(diffLivingSocket).connect(consumers.livingSocket)
    outputSocket(diffLivingConvector).connect(consumers.livingConvector)

    outputSocket(diffBathLight).connect(consumers.bathLight)
    outputSocket(diffBathSocket).connect(consumers.bathSocket)
    outputSocket(diffBathWasher).connect(consumers.bathWasher)

    outputSocket(diffCorridorLight).connect(consumers.corridorLight)
    outputSocket(diffCorridorSocket).connect(consumers.corridorSocket)
    outputSocket(diffWardrobeLight).connect(consumers.wardrobeLight)
    outputSocket(diffWardrobeSocket).connect(consumers.wardrobeSocket)
    outputSocket(diffWcLight).connect(consumers.wcLight)
    outputSocket(diffWcSocket).connect(consumers.wcSocket)

    outputSocket(diffBoilerLight).connect(consumers.boilerLight)
    outputSocket(diffBoilerSocket).connect(consumers.boilerSocket)
    outputSocket(diffBoilerGasBoiler).connect(consumers.boilerGasBoiler)

    outputSocket(diffAtticLight).connect(consumers.atticLight)
    outputSocket(diffAtticSocket1).connect(consumers.atticSocket1)
    outputSocket(diffAtticSocket2).connect(consumers.atticSocket2)

}

