package com.designpatterns.observer.propertychange;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Store{
    PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener subscriber) {
        if(subscriber != null) this.support.addPropertyChangeListener(subscriber);
    }

    public void removeSubscriber(PropertyChangeListener subscriber) {
        if(subscriber != null) this.support.removePropertyChangeListener(subscriber);
    }

    public void notifySubscribers(String message) {
        support.firePropertyChange("event name", null, message);
    }

    public void arriveNewItem() {
        System.out.println("Arrive New Item");
        this.notifySubscribers("arrive New Item");
    }
}
