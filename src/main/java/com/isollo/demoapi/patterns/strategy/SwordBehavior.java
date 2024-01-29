package com.isollo.demoapi.patterns.strategy;

public class SwordBehavior implements WeaponBehavior{
    @Override
    public void attack() {
        System.out.println("Attack with sword");
    }
}
