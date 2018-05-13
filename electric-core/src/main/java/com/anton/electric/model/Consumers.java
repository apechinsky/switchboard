package com.anton.electric.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Q-APE
 */
public class Consumers {

    private List<Consumer> consumers = new ArrayList<>();

    protected Consumer consumer(String id, String name, int current, double price) {
        Consumer consumer = new Consumer(id, name, current, price);

        consumers.add(consumer);

        return consumer;
    }

    public int count() {
        return consumers.size();
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }
}
