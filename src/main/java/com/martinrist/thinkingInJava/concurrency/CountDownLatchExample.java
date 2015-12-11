package com.martinrist.thinkingInJava.concurrency;

import java.util.concurrent.*;

public class CountDownLatchExample {

    private static final int WAITERS = 5;

    public static void main(String[] args) {

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(WAITERS);
        CountDownLatch latch = new CountDownLatch(WAITERS);

        System.out.println("Scheduling Waiting Tasks");
        for (int i = 1; i <= WAITERS ; i++) {
            WaitingTask w = new WaitingTask(i * 1000, latch);
            exec.schedule(Executors.callable(w), i/2, TimeUnit.SECONDS);
        }

        System.out.println("Awaiting latch in main thread");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completing - latch counter @ " + latch.getCount());
        exec.shutdown();

    }




}