package com.isollo.demoapi.guitar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GuitarInventory implements Inventory<Guitar, GuitarSpec> {
    List<Guitar> items;

    public GuitarInventory() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Guitar item) {
        this.items.add(item);
    }

    @Override
    public Optional<Guitar> getById(String id) {
        return this.items.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Guitar> searchBySpec(GuitarSpec spec) {
        return this.items.stream()
                .filter(g -> (g.getSpec().getType().equals(spec.getType())) && spec.getModel() == null || g.getSpec().getModel().equals(spec.getModel()))
                .collect(Collectors.toList());
    }
}
