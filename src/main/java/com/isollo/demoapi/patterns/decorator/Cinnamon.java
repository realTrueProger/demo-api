package com.isollo.demoapi.patterns.decorator;

public class Cinnamon extends CondimentDecorator {
    public Cinnamon(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Cinnamon";
    }
}
