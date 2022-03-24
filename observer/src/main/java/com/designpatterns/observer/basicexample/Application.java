package com.designpatterns.observer.basicexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Store store = new Store();

        String[] names = {"마르코", "도진", "연선", "은혁", "지웅", "현서"};
        List<Customer> customers = new ArrayList<>();
        for(String name:names) customers.add(new Customer(name));
        for(Customer customer:customers) store.addSubscriber(customer);

        Random random = new Random();
        int days = 0;
        while(true) {
            System.out.println(++days+"일차");
            Boolean hasArriveNewItem = random.nextInt(5) == 0;
            if(hasArriveNewItem) {
                store.arriveNewItem();
                break;
            };
        }
    }
}
