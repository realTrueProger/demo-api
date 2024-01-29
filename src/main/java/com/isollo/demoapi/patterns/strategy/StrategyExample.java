package com.isollo.demoapi.patterns.strategy;

public class StrategyExample {
    public static void main(String[] args) {
        var knight = new Knight();
        knight.setWeaponBehavior(new SwordBehavior());
        knight.attackWithWeapon();
        knight.setMagicBehavior(new FireBallBehaviour());
        knight.useMagic();
    }
}
