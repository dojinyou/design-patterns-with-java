package com.designpatterns.observer.basicexample;

public class Customer implements MyObserver {
    private String name;

    Customer(String name) {
        this.name = name;
    }
    @Override
    public void update() {
        System.out.println("to "+this.name+"\n: item이 도착했습니다!");
    }
}
