package com.designpatterns.observer.flow;

import java.util.concurrent.Flow;

public class Customer implements Flow.Subscriber {
    private String name;
    private Flow.Subscription subscription;

    Customer(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(Object context) {
        System.out.println("to "+this.name+"\n: "+context);
    }
    @Override
    public void onError(Throwable throwable) {}
    @Override
    public void onComplete() {}
}