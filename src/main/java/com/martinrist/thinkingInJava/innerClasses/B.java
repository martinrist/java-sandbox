package com.martinrist.thinkingInJava.innerClasses;

/**
 * Class 'B' as required for Exercise 23 of 'Thinking in Java' chapter
 * 'Inner Classes'.
 */
public class B {

    private static final int ARRAY_SIZE = 10;
    private U[] us = new U[ARRAY_SIZE];

    private void validateArrayBounds(int index) {
        if (index < 0 || index >= ARRAY_SIZE) {
            throw new IllegalArgumentException("Invalid value for index: " + index + ".  Array size is " + ARRAY_SIZE);
        }
    }

    public void setEntry(int index, U u) {
        validateArrayBounds(index);
        us[index] = u;
    }

    public void removeEntry(int index) {
        validateArrayBounds(index);
        us[index] = null;
    }

    public void callUsMethods() {
        for (U u : us) {

            if (u != null) {
                System.out.println("Calling methods on " + u);
                u.method1();
                u.method2();
                u.method3();
            }
        }
    }

}
