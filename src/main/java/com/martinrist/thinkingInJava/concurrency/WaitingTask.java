package com.martinrist.thinkingInJava.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * A task that waits for a specified period of time before outputting
 * a message and ending.
 */
public class WaitingTask implements Runnable {

    private static int counter = 1;
    private int id = counter++;
    private long waitMs;
    private CountDownLatch latch;

    public WaitingTask(long waitMs, CountDownLatch latch) {
        this.waitMs = waitMs;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + this);
        try {
            TimeUnit.MILLISECONDS.sleep(waitMs);
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + this);
        }
        System.out.println("Finishing: " + this);
        latch.countDown();
        System.out.println("Decreasing latch counter to: " + latch.getCount());
    }

    @Override
    public String toString() {
        return String.format("Task [%d] - waiting for %d ms - latch @ %d", id, waitMs, latch.getCount());
    }
}
