package com.martinrist.effectiveJava.chapter2.nonInstantiability;

/**
 * Example utility class that has been explicitly made non-instantiable
 * using a private constructor.
 */
public class UtilityClass {

    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
}