package com.designpatterns.observer.flowasync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Store<T> extends SubmissionPublisher<T> {
    private List<Flow.Subscriber> subscribers = new ArrayList<>();
    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void arriveNewItem() {
        System.out.println("Arrive New Item");
        this.notifySubscribers("arrive New Item");
    };

    public void notifySubscribers(String context) {
        this.submit((T) context);
//        for(Flow.Subscriber subscriber:subscribers){
//            subscriber.onNext(context);
//        }
    }
}
