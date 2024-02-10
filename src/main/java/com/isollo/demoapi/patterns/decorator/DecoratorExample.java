package com.isollo.demoapi.patterns.decorator;

public class DecoratorExample {
    public static void main(String[] args) {
        // Please make Latte with IceCream and cinnamon
        Beverage order = new Latte();
        order = new IceCream(order);
        order = new Cinnamon(order);
        System.out.println("Order: " + order.getDescription());
        System.out.println("Price: " + order.cost() + "$");

        // Please make Expresso
        Beverage order2 = new Espresso();
        System.out.println("Order: " + order2.getDescription());
        System.out.println("Price: " + order2.cost() + "$");
    }
}
