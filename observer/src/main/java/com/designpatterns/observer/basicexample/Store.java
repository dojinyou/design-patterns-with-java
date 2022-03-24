package com.designpatterns.observer.basicexample;

import java.util.ArrayList;
import java.util.List;

public class Store implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(subscriber != null) this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber != null) this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber subscriber:subscribers){
            subscriber.update("arrive new Item");
        }
    }

    public void arriveNewItem() {
        System.out.println("Arrive New Item");
        this.notifySubscribers();
    }
}
