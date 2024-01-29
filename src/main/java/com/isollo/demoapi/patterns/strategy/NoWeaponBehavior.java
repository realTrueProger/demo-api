package com.isollo.demoapi.patterns.strategy;

public class NoWeaponBehavior implements WeaponBehavior{
    @Override
    public void attack() {
        System.out.println("No weapon");
    }
}
