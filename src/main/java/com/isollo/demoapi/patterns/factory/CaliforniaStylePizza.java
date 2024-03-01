package com.isollo.demoapi.patterns.factory;

public class CaliforniaStylePizza extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if(type.equals("CheesePizza")) {
            pizza = new CACheesePizza();
        } else if (type.equals("MeatPizza")) {
            pizza = new CAMeatPizza();
        }

        return pizza;
    }
}
