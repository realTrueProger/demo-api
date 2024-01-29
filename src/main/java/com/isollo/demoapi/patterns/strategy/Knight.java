package com.isollo.demoapi.patterns.strategy;

public class Knight extends Character{
    public Knight() {
        this.weaponBehavior = new NoWeaponBehavior();
        this.magicBehavior = new NoMagicBehavior();
        this.hp = 100;
        this.mp = 100;
    }
}
