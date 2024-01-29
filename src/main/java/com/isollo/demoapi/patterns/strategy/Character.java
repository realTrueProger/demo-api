package com.isollo.demoapi.patterns.strategy;

import lombok.Setter;

@Setter
public abstract class Character {
    WeaponBehavior weaponBehavior;
    MagicBehavior magicBehavior;
    Integer hp;
    Integer mp;

    public void attackWithWeapon() {
        weaponBehavior.attack();
    }

    public void useMagic() {
        magicBehavior.useMagic();
    }
}
