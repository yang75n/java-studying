package com.yqw.java.flow;

public class Main {
    public static void main(String[] args) {
        CountPublisher publisher = new CountPublisher(500);
        CountSubscriber subscriber = new CountSubscriber(15);
        publisher.subscribe(subscriber);
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
