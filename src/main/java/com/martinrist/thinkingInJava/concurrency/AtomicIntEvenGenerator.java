package com.martinrist.thinkingInJava.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementation of an IntGenerator that generates even integers.
 *
 * This class is safe for shared use from multiple threads, because it
 * uses an `AtomicInteger` to ensure that the value is incremented atomically.
 *
 * In addition, the use of `AtomicInteger` avoids memory consistency errors.
 */
public class AtomicIntEvenGenerator extends IntGenerator {

    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicIntEvenGenerator());
    }
}

