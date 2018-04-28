import com.anton.electric.model.Consumer

/**
 * Потребители электроэнергии дома.
 * 
 * <p>Потребителями считаются электроприборы, включая светильники и группы розеток.</p>
 *
 * <p>Класс создан, чтобы
 * 
 * @author Q-APE
 */
class Consumers {

    private List<Consumer> consumers = []

    def kitchenLight = consumer("kitchenLight", "Кухня. Свет.", 10, 0)
    def kitchenSocket = consumer("kitchenSocket", "Кухня. Розетки.", 16, 0)
    def kitchenCooker = consumer("kitchenCooker", "Кухня. Электроплита.", 25, 0)
    def kitchenFridge = consumer("kitchenFridge", "Кухня. Холодильник.", 16, 0)
    def kitchenDishWasher = consumer("kitchenDishWasher", "Кухня. Посудомойка.", 16, 0)
    def kitchenConvector = consumer("kitchenConvector", "Кухня. Конвектор.", 16, 0)

    def bed1Light = consumer("bed1Light", "Спальня 1. Свет", 10, 0)
    def bed1Socket = consumer("bed1Socket", "Спальня 1. Розетки", 16, 0)

    def bed2Light = consumer("bed2Light", "Спальня 2. Свет", 10, 0)
    def bed2Socket = consumer("bed2Socket", "Спальня 2. Розетки", 16, 0)

    def bed3Light = consumer("bed3Light", "Спальня 3. Свет", 10, 0)
    def bed3Socket = consumer("bed3Socket", "Спальня 3. Розетки", 16, 0)

    def livingLight = consumer("livingLight", "Гостиная. Свет", 10, 0)
    def livingSocket = consumer("livingSocket", "Гостиная. Розетки", 16, 0)
    def livingConvector = consumer("livingConvector", "Гостиная. Конвекторы", 16, 0)

    def bathLight = consumer("bathLight", "Ванная. Свет", 10, 0)
    def bathSocket = consumer("bathSocket", "Ванная. Розетки", 16, 0)
    def bathWasher = consumer("bathWasher", "Ванная. Стиральная машина", 16, 0)

    def wcLight = consumer("wcLight", "Туалет. Свет", 10, 0)
    def wcSocket = consumer("wcSocket", "Туалет. Вывод", 16, 0)

    def wardrobeLight = consumer("wardrobeLight", "Гардероб. Свет", 10, 0)
    def wardrobeSocket = consumer("wardrobeSocket", "Гардероб. Розетки", 16, 0)

    def corridorLight = consumer("corridorLight", "Коридор. Свет", 10, 0)
    def corridorSocket = consumer("corridorSocket", "Коридор. Розетки", 16, 0)

    def boilerLight = consumer("boilerLight", "Топочная. Свет", 10, 0)
    def boilerSocket = consumer("boilerSocket", "Топочная. Розетки", 16, 0)
    def boilerGasBoiler = consumer("boilerGasBoiler", "Топочная. Котел", 16, 0)

    def atticLight = consumer("atticLight", "Мансарда. Свет.", 10, 0)
    def atticSocket1 = consumer("atticSocket1", "Мансарда. Розетки.", 16, 0)
    def atticSocket2 = consumer("atticSocket2", "Мансарда. Розетки.", 16, 0)


    private Consumer consumer(String id, String name, int current, double price) {
        def consumer = new Consumer(id, name, current, price)
        consumers += consumer
        return consumer
    }

    int count() {
        return consumers.size()
    }



}
