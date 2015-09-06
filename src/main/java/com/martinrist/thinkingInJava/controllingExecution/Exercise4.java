package com.martinrist.thinkingInJava.controllingExecution;

/**
 * Thinking in Java - 'Controlling Execution' Chapter
 * Exercise 4 - Find primes up to (and including) a specified value.
 */
public class Exercise4 {

    public static final int MAX_NUMBER = 100;

    private static PrimeUtils pc = new PrimeUtils();

    public static void main(String[] args) {

        System.out.println("Primes up to " + MAX_NUMBER);

        for (int i = 1; i <= MAX_NUMBER ; i++) {
            if (pc.isPrime(i)) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }


}
