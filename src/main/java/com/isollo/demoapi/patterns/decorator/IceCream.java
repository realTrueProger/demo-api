package com.isollo.demoapi.patterns.decorator;

public class IceCream extends CondimentDecorator {
    public IceCream(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", IceCream";
    }
}
