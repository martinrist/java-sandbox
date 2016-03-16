package com.martinrist.effectiveJava.chapter2.factoryMethod;

/**
 * Simple implementation of @see Calculator interface, that just delegates
 * to the built-in operators.
 */
class SimpleCalculator implements Calculator {

    @Override
    public int add(int x, int y) {
        return x + y;
    }

}