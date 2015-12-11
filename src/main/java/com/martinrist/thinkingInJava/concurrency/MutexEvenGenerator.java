package com.martinrist.thinkingInJava.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Correct implementation of an IntGenerator that generates even integers.
 *
 * This class is safe for shared use from multiple threads, because it
 * creates an explicity Lock, as opposed to the monitor lock used by
 * SynchronisedEvenGenerator.
 */
public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {

        lock.lock();

        try {
            ++currentEvenValue;     // No longer dangerous, due to the acquisition of lock()
            Thread.yield();         // This call increases the chance of interference from another thread.
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();          // Note the need to call unlock() in the finally block
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}

