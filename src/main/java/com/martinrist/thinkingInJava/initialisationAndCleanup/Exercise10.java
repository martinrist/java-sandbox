package com.martinrist.thinkingInJava.initialisationAndCleanup;

/**
 * Thinking in Java - 'Initialisation & Cleanup' Chapter
 * Exercise 10 - Class with finalize()
 */
public class Exercise10 {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Exercise10.finalize() called");
    }

    public static void main(String[] args) {
        Exercise10 e10 = new Exercise10();

        // finalize() isn't called here, because the GC never gets a chance to run.
   }

}
