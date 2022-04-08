package com.designpatterns.observer.basicexample;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<MyObserver> observers = new ArrayList<>();

    default void registerObserver(MyObserver observer){
        if(observer != null) this.observers.add(observer);
    };
    default void unregisterObserver(MyObserver observer) {
        if(observer != null) this.observers.remove(observer);
    };

    default void notifyObservers() {
        for(MyObserver observer:observers){
            observer.update();
        }
    };
}
