package com.isollo.demoapi.guitar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuitarInventoryTest {
    private GuitarInventory guitarInventory;

    @BeforeEach
    void setUp() {
        this.guitarInventory = new GuitarInventory();
    }

    @Test
    void itShouldAdd() {
        Guitar guitar1 = new Guitar("1", 99.99, new GuitarSpec("electron200", GuitarType.ELECTRO));
        guitarInventory.add(guitar1);

        assertThat(guitarInventory.getById("1")).isPresent();
        assertThat(guitarInventory.getById("2")).isNotPresent();
    }

    @Test
    void itShouldGetById() {
        Guitar guitar1 = new Guitar("1", 99.99, new GuitarSpec("electron200", GuitarType.ELECTRO));
        guitarInventory.add(guitar1);

        assertThat(guitarInventory.getById("1")).isPresent();
    }

    @Test
    void itShouldSearchBySpec() {
        Guitar guitar1 = new Guitar("1", 99.99, new GuitarSpec("electron200", GuitarType.ELECTRO));
        Guitar guitar2 = new Guitar("2", 99.99, new GuitarSpec("electron200", GuitarType.ELECTRO));
        guitarInventory.add(guitar1);
        guitarInventory.add(guitar2);

        assertThat(guitarInventory.searchBySpec(new GuitarSpec(null, GuitarType.ELECTRO))).hasSize(2);
    }
}