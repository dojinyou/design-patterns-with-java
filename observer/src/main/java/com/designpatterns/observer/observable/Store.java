package com.designpatterns.observer.observable;

import com.designpatterns.observer.basicexample.Publisher;
import com.designpatterns.observer.basicexample.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Store extends Observable {
    public void arriveNewItem() {
        System.out.println("Arrive New Item");
        this.setChanged();
        this.notifyObservers("arrive New Item");
    }
}
