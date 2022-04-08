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
        subscription.request(1);
    }

    @Override
    public void onNext(Object context) {
        System.out.println("to " + this.name + "\n: " + context);
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void onError(Throwable throwable) {
    }

    @Override
    public void onComplete() {
    }
}