package com.designpatterns.observer.observable;

import java.util.Observable;

public class Store extends Observable {
    public void arriveNewItem() {
        System.out.println("Arrive New Item");
        this.setChanged();
        this.notifyObservers("arrive New Item");
    }
}
