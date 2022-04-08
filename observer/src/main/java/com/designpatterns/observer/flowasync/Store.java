package com.designpatterns.observer.flowasync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Store<String> extends SubmissionPublisher<String> {
    public void arriveNewItem() {
        System.out.println("Arrive New Item");
        this.submit((String) "arrive New Item");
    };

//    public void notifySubscribers(String context) {
//        this.submit(context);
////        for(Flow.Subscriber subscriber:subscribers){
////            subscriber.onNext(context);
////        }
//    }
}
