package com.martinrist.effectiveJava.chapter2.singleton;

/**
 * Implementation of a singleton using a public static final field.
 */
public class ElvisSingletonWithFactoryMethod {

    private static final ElvisSingletonWithFactoryMethod INSTANCE = new ElvisSingletonWithFactoryMethod();

    private ElvisSingletonWithFactoryMethod() {
        // private constructor to enforce non-instantiability
    }

    public static ElvisSingletonWithFactoryMethod getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        // ... implementation goes here
    }
}
