package com.martinrist.thinkingInJava.concurrency;

/**
 * Base class for all classes that Generate ints, and can be called.
 */
public abstract class IntGenerator {

    private volatile boolean cancelled = false;

    public abstract int next();

    public void cancel() { cancelled = true; }

    public boolean isCancelled() { return cancelled; }

}
