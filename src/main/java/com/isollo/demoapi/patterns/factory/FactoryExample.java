package com.isollo.demoapi.patterns.factory;

public class FactoryExample {
    public static void main(String[] args) {
        // California Cheese Pizza
        Pizza caCheesePizza = new CaliforniaStylePizza().orderPizza("CheesePizza");
        System.out.println(caCheesePizza.getName());

        // NY Meat Pizza
        Pizza nyMeatPizza = new NYStylePizza().orderPizza("MeatPizza");
        System.out.println(nyMeatPizza.getName());
    }
}
