package com.designpatterns.observer.basicexample;

public class Customer implements Subscriber {
    private String name;

    Customer(String name) {
        this.name = name;
    }
    @Override
    public void update(Object context) {
        System.out.println("to "+this.name+" : "+context);
    }
}
