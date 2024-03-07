package com.isollo.demoapi.myreflectiontest;

import java.lang.reflect.Field;

public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User();

        // get private field name
        Field privateNameField = User.class.getDeclaredField("name");
        privateNameField.setAccessible(true);
        System.out.println(privateNameField.get(user));

        // change private field
        privateNameField.set(user, "changed private value");
        System.out.println(privateNameField.get(user));
    }

}
