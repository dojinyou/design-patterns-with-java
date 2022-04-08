package com.designpatterns.observer.flowasync;

import java.util.concurrent.Flow;

public class Customer implements Flow.Subscriber<String> {
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
    public void onNext(String context) {
        StringBuffer sb = new StringBuffer();
        sb.append("to ");
        sb.append(this.name);
        sb.append(": ");
        sb.append(context);
        System.out.println(sb);
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void onError(Throwable throwable) {
    }

    @Override
    public void onComplete() {
    }
}
