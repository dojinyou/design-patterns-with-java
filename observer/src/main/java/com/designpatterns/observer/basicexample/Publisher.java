package com.designpatterns.observer.basicexample;

import java.util.ArrayList;
import java.util.List;

public interface Publisher {
    List<Subscriber> subscribers = new ArrayList<>();


    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);

    void notifySubscribers();
}
