package com.martinrist.thinkingInJava.initialisationAndCleanup;

/**
 * Thinking in Java - 'Initialisation & Cleanup' Chapter
 * Exercise 12 - Exercising a Tank class that has a finalize method that
 * tests a termination condition.
 */
public class Exercise12 {

    public static void main(String[] args) {

        Tank emptyTank = new Tank();
        Tank fullTank = new Tank();
        fullTank.fill();

        // emptyTank and fullTank are still in scope at this point
        // so the finalisers won't run
        System.gc();
        System.runFinalization();

        // Aggressively null out the refs, so now they're eligible for GC
        emptyTank = null;
        fullTank = null;

        System.gc();

        try {
            System.runFinalization();
        } catch (IllegalStateException ise) {
            // This never gets called, because even though the finaliser
            // throws an IllegalStateException, it gets ignored.
            System.err.println("Got an exception " + ise);
        }


    }

}
