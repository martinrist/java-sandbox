package com.martinrist.thinkingInJava.concurrency;

/**
 * Incorrect implementation of an IntGenerator that is supposed to generate
 * even integers.
 *
 * This class is not safe for shared use from multiple threads, due to the
 * non-atomic double-increment of `currentEvenValue` in `next()`.
 */
public class BrokenEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;     // Danger point here
        Thread.yield();         // This call increases the chance of interference from another thread.
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new BrokenEvenGenerator());
    }
}

