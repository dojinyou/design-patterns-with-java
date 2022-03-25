package com.designpatterns.observer.basicexample;

public class Store implements Subject {
    public void arriveNewItem() {
        System.out.println("Arrive New Item");
        this.notifyObservers();
    }
}
