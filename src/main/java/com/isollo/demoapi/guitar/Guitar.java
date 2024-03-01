package com.isollo.demoapi.guitar;

import java.util.Objects;

public class Guitar {
    String id;
    Double price;
    GuitarSpec spec;

    public Guitar(String id, Double price, GuitarSpec spec) {
        this.id = id;
        this.price = price;
        this.spec = spec;
    }

    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public GuitarSpec getSpec() {
        return spec;
    }

    public void setSpec(GuitarSpec spec) {
        this.spec = spec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guitar guitar = (Guitar) o;
        return Objects.equals(id, guitar.id) && Objects.equals(price, guitar.price) && Objects.equals(spec, guitar.spec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, spec);
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", spec=" + spec +
                '}';
    }
}
