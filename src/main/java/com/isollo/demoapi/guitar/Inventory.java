package com.isollo.demoapi.guitar;

import java.util.List;
import java.util.Optional;

public interface Inventory<T, U> {
    void add(T item);
    Optional<T> getById(String id);
    List<T> searchBySpec(U spec);
}
