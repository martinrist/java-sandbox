package com.martinrist.sandbox.concurrency.callable;

import com.martinrist.sandbox.concurrency.callables.IntegerCallableWithDelay;
import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.*;

public class CallableTest {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Test
    public void testIntegerCallableWithoutDelay_ReturnsCorrectResult() throws Exception {
        Callable<Integer> callable = new IntegerCallableWithDelay(0, 1);
        Future<Integer> future = executor.submit(callable);
        assertEquals(Integer.valueOf(1), future.get());
    }

    @Test
    public void testIntegerCallableWithDelay_ReturnsCorrectResultAfterWaiting() throws Exception {
        Callable<Integer> callable = new IntegerCallableWithDelay(100, 1);
        Future<Integer> future = executor.submit(callable);
        assertEquals(Integer.valueOf(1), future.get());
    }

    @Test
    public void testIntegerCallableWithDelay_FutureIsNotInitiallyDone() throws Exception {
        Callable<Integer> callable = new IntegerCallableWithDelay(100, 1);
        Future<Integer> future = executor.submit(callable);
        assertFalse(future.isDone());
    }

    @Test
    public void testIntegerCallableWithDelay_FutureIsDoneAfterGet() throws Exception {
        Callable<Integer> callable = new IntegerCallableWithDelay(100, 1);
        Future<Integer> future = executor.submit(callable);
        future.get();
        assertTrue(future.isDone());
    }

    @Test
    public void testIntegerCallableWithDelay_ThrowsTimeoutExceptionIfTimeoutExceeded() throws Exception {
        Callable<Integer> callable = new IntegerCallableWithDelay(100, 1);
        Future<Integer> future = executor.submit(callable);
        try {
            future.get(0, TimeUnit.MILLISECONDS);
        } catch (TimeoutException te) {
            // Expected result
            return;
        }

        fail("Expected TimeoutException not thrown");
    }

}


