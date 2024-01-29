package com.isollo.demoapi.patterns.strategy;

public class NoMagicBehavior implements MagicBehavior{
    @Override
    public void useMagic() {
        System.out.println("No magic to use");
    }
}
