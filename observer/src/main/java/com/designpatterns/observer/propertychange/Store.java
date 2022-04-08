package com.designpatterns.observer.propertychange;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Store {
    PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener observer) {
        if (observer != null) this.support.addPropertyChangeListener(observer);
    }

    public void removeSubscriber(PropertyChangeListener observer) {
        if (observer != null) this.support.removePropertyChangeListener(observer);
    }

    public void notifySubscribers(String newValue) {
        support.firePropertyChange("event name", null, newValue);
    }

    public void arriveNewItem() {
        System.out.println("Arrive New Item");
        this.notifySubscribers("arrive New Item");
    }
}
