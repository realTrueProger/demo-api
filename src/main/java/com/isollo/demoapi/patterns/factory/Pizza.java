package com.isollo.demoapi.patterns.factory;

public abstract class Pizza {
    String name;

    public String getName() {
        return name;
    }

    void prepare() {}
    void bake() {}
    void box() {}
}
