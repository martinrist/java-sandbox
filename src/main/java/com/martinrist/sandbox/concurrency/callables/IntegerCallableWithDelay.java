package com.martinrist.sandbox.concurrency.callables;

import java.util.concurrent.Callable;

public class IntegerCallableWithDelay implements Callable<Integer> {

    private int delay;
    private Integer result;

    public IntegerCallableWithDelay(int delay, Integer result) {
        this.delay = delay;
        this.result = result;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(delay);
        return result;
    }
}
