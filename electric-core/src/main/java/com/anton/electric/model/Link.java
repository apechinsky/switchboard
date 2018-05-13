package com.anton.electric.model;

/**
 * Связь. Описывает связь двух коннекторов.
 *
 * @author Q-APE
 */
public interface Link {

    /**
     * Первый коннектор
     */
    Connector first();

    /**
     * Второй коннектор
     */
    Connector second();

    /**
     * Провод, использующийся в данной связи.
     */
    Wire wire();

    /**
     * Возвращает противоположный коннектор указанному.
     *
     * @param connector первый либо второй коннектор
     * @return первый коннектор, если параметр был вторым и наоборот
     * @throws IllegalArgumentException если параметр не участвует в данной связи
     */
    Connector peer(Connector connector);


    static Link create(Wire wire, Connector first, Connector second) {
        return new LinkImpl(wire, first, second);
    }

}
