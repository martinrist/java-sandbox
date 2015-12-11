package com.martinrist.thinkingInJava.concurrency;

/**
 * Correct implementation of an IntGenerator that generates even integers.
 *
 * This class is safe for shared use from multiple threads, due to the
 * synchronisation of `next()`
 */
public class SynchronisedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;     // No longer dangerous, as the whole method is synchronised
        Thread.yield();         // This call increases the chance of interference from another thread.
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronisedEvenGenerator());
    }
}

