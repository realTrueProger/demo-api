package com.isollo.demoapi.patterns.observer;

public class Suscriber implements Observer{
    @Override
    public void update(String updateString) {
        System.out.println("Breaking news!!!");
        System.out.println(updateString);
    }
}
