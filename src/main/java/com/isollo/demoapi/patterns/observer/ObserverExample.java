package com.isollo.demoapi.patterns.observer;

public class ObserverExample {
    public static void main(String[] args) {
        NewsChannel Russia24 = new NewsChannel();
        Suscriber sub1 = new Suscriber();
        Suscriber sub2 = new Suscriber();

        Russia24.registerObserver(sub1);
        Russia24.registerObserver(sub2);
        Russia24.publishNews("Putin interview released!!!");

        Russia24.removeObserver(sub2);
        Russia24.publishNews("Donald Trump is the new President in United States!!!");
    }
}
