package com.isollo.demoapi.guitar;

import java.util.Objects;

public class GuitarSpec {
    String model;
    GuitarType type;

    public GuitarSpec(String model, GuitarType type) {
        this.model = model;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public GuitarType getType() {
        return type;
    }

    public void setType(GuitarType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuitarSpec that = (GuitarSpec) o;
        return Objects.equals(model, that.model) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, type);
    }

    @Override
    public String toString() {
        return "GuitarSpec{" +
                "model='" + model + '\'' +
                ", type=" + type +
                '}';
    }
}
