package com.martinrist.effectiveJava.chapter2.singleton;

/**
 * Implementation of a singleton using a public static final field.
 */
public class ElvisSingletonWithField {

    public static final ElvisSingletonWithField INSTANCE = new ElvisSingletonWithField();

    private ElvisSingletonWithField() {
        // private constructor to enforce non-instantiability
    }

    public void leaveTheBuilding() {
        // ... implementation goes here
    }
}
