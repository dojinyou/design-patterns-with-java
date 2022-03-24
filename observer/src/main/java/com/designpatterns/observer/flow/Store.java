package com.designpatterns.observer.flow;

import com.designpatterns.observer.basicexample.Subscriber;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class Store implements Flow.Publisher{
    private List<Flow.Subscriber> subscribers = new ArrayList<>();
    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void arriveNewItem() {
        System.out.println("Arrive New Item");
        this.notifySubscribers("arrive New Item");
    };

    public void notifySubscribers(String context) {
        for(Flow.Subscriber subscriber:subscribers){
            subscriber.onNext(context);
        }
    }
}
