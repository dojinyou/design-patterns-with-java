package com.designpatterns.observer.flowasync;

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
        this.subscription.request(1);
        System.out.println("subscribe");
    }

    @Override
    public void onNext(Object context) {
        System.out.println("to "+this.name+"\n: "+context);
        System.out.println(Thread.currentThread().getName());
        this.subscription.request(1);
    }
    @Override
    public void onError(Throwable throwable) {
        System.out.println("error");
    }
    @Override
    public void onComplete() {
        System.out.println("complete");
    }
}
