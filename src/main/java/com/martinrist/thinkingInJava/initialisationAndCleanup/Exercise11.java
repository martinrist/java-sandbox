package com.martinrist.thinkingInJava.initialisationAndCleanup;

/**
 * Thinking in Java - 'Initialisation & Cleanup' Chapter
 * Exercise 11 - Class with finalize() with call to System.gc() in main()
 */
public class Exercise11 {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Exercise11.finalize() called");
    }

    public static void main(String[] args) {
        Exercise11 e11 = new Exercise11();
        System.gc();
        System.runFinalization();

        // finalize() isn't always called even here,
        // because System.gc() and System.runFinalization() are just suggestions.
   }

}
