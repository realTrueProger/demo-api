package com.isollo.demoapi.patterns.factory;

public class NYStylePizza extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if(type.equals("CheesePizza")) {
            pizza = new NYCheesePizza();
        } else if (type.equals("MeatPizza")) {
            pizza = new NYMeatPizza();
        }

        return pizza;
    }
}
