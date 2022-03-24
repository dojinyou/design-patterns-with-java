package com.designpatterns.observer.observable;

import com.designpatterns.observer.basicexample.Subscriber;

import java.util.Observable;
import java.util.Observer;

public class Customer implements Observer {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object context) {
        System.out.println("to "+this.name+"\n: "+context);
    }
}