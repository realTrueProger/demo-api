package com.isollo.demoapi.patterns.strategy;

public class FireBallBehaviour implements MagicBehavior{
    @Override
    public void useMagic() {
        System.out.println("Launch giant fireball!!!");
    }
}
