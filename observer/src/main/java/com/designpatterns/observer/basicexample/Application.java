package com.designpatterns.observer.basicexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // 초기화
        Store store = new Store();
        String[] names = {"마르코", "도진", "연선", "은혁", "지웅", "현서"};
        List<Customer> customers = new ArrayList<>();
        for(String name:names) customers.add(new Customer(name));
        for(Customer customer:customers) store.registerObserver(customer);
        
        // 랜덤 이벤트 발생 및 이벤트 전달
        Random random = new Random();
        int days = 0;
        while(true) {
            System.out.println(++days+"일차");
            // 5분의 1의 확률로 새로운 아이템 도착
            Boolean hasArrivedNewItem = random.nextInt(5) == 0;
            if(!hasArrivedNewItem) continue;

            store.arriveNewItem();
            break;
        }
    }
}
