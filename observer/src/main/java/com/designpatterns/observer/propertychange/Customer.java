package com.designpatterns.observer.propertychange;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;

public class Customer implements PropertyChangeListener {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        System.out.println("to "+this.name+"\n: "+event.getNewValue());
    }
}