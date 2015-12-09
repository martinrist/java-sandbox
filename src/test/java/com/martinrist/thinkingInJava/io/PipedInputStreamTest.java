package com.martinrist.thinkingInJava.io;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class PipedInputStreamTest {

    public static final int TEST_VALUE = 42;
    private final PipedInputStream testObject = new PipedInputStream();
    private final PipedOutputStream source = new PipedOutputStream();

    @Before
    public void setUp() throws Exception {
        testObject.connect(source);
    }

    @Test
    public void test_GivenNewStream_WhenAvailableBytesChecked_ThenReturnsZero() throws IOException {
        assertThat(testObject.available(), is(0));
    }

    @Test
    public void test_GivenValueWrittenToSource_WhenAvailableBytesChecked_ThenReturnsOne() throws IOException {
        source.write(TEST_VALUE);
        assertThat(testObject.available(), is(1));
    }

    @Test
    public void test_GivenValueWrittenToSource_WhenValueRead_ThenReturnsExpectedValue() throws IOException {
        source.write(TEST_VALUE);
        assertThat(testObject.read(), is(TEST_VALUE));
    }

    @Test
    public void test_GivenMultipleValuesWrittenToSource_WhenAvailableBytesChecked_ThenReturnsExpectedValue() throws IOException {
        source.write(TEST_VALUE);
        source.write(TEST_VALUE + 1);
        source.write(TEST_VALUE + 2);
        assertThat(testObject.available(), is(3));
    }

    @Test
    public void test_GivenMultipleValuesWrittenToSource_WhenValueRead_ThenAvailabilityReduces() throws IOException {
        source.write(TEST_VALUE);
        source.write(TEST_VALUE + 1);
        source.write(TEST_VALUE + 2);
        testObject.read();
        assertThat(testObject.available(), is(2));
    }

    @Test
    public void test_GivenEmptySource_WhenValueReadFromDest_ThenBlocksUntilWriteToSource() throws IOException {

        int delayMs = 200;

        Executors.newScheduledThreadPool(1).schedule((Runnable) () -> {
            try {
                source.write(TEST_VALUE);
            } catch (IOException e) {
                System.out.println("oops - problem!");
                fail("Unable to write to source PipedOutputStream");
            }
        }, delayMs, TimeUnit.MILLISECONDS);

        // This is going to block until the thread created above puts the value
        // in the PipedOutputStream
        long startTime = System.currentTimeMillis();
        int result = testObject.read();
        long endTime = System.currentTimeMillis();
        int elapsedMs = (int)(endTime - startTime);

        assertThat(result, is(TEST_VALUE));
        assertThat(elapsedMs, greaterThan(delayMs));

    }
}
