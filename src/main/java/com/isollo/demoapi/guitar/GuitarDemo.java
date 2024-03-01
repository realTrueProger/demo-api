package com.isollo.demoapi.guitar;

import java.util.List;

public class GuitarDemo {
    public static void main(String[] args) {
        GuitarInventory guitarInventory = new GuitarInventory();
        fillInventory(guitarInventory);

        //user request for guitars by spec
        GuitarSpec userRequest1 = new GuitarSpec(null, GuitarType.ELECTRO);
        List<Guitar> foundItems = guitarInventory.searchBySpec(userRequest1);

        if(foundItems.isEmpty()) {
            System.out.println("No guitars found");
        } else {
            System.out.println(foundItems);
        }
    }

    public static void fillInventory(GuitarInventory guitarInventory) {
        //add guitar 1
        GuitarSpec electro1 = new GuitarSpec("electron200", GuitarType.ELECTRO);
        Guitar guitar1 = new Guitar("1", 99.99, electro1);

        //add guitar 2
        GuitarSpec electro2 = new GuitarSpec("electronMXPro", GuitarType.ELECTRO);
        Guitar guitar2 = new Guitar("2", 299.99, electro2);

        guitarInventory.add(guitar1);
        guitarInventory.add(guitar2);
    }
}
