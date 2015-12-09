package com.martinrist.thinkingInJava.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ByteArrayInputStreamTest {

    public static final int BUFFER_SIZE = 10;
    public static final int END_OF_STREAM_SENTINEL = -1;
    private final InputStream testObject = new ByteArrayInputStream(createBuffer(BUFFER_SIZE));

    @Test
    public void test_GivenEmptyByteArray_WhenReadingFromInputStream_ThenReturnsSentinelValue() throws IOException {

        InputStream emptyStream = new ByteArrayInputStream(createBuffer(0));

        assertThat(emptyStream.read(), is(-1));

    }

    @Test
    public void test_GivenNonEmptyByteArray_WhenReadingFromInputStream_ThenReturnsExpectedValues() throws IOException {

        for (int i = 0; i < BUFFER_SIZE; i++) {
            assertThat(testObject.read(), is(i));
        }

    }

    @Test
    public void test_GivenNonEmptyByteArray_WhenReadingPastEndOfStream_ThenReturnsSentinelValue() throws IOException {

        for (int i = 0; i < BUFFER_SIZE; i++) {
            testObject.read();
        }
        assertThat(testObject.read(), is(END_OF_STREAM_SENTINEL));

    }


    @Test
    public void test_GivenNonEmptyByteArray_WhenCheckingAvailability_ThenReturnsInitialSize() throws IOException {
        assertThat(testObject.available(), is(BUFFER_SIZE));
    }


    @Test
    public void test_GivenSingleValueRead_WhenCheckingAvailabilty_ThenAvailabilityDecremented() throws IOException {
        int available = testObject.available();
        testObject.read();
        assertThat(testObject.available(), is(available - 1));
    }

    private byte[] createBuffer(final int size) {

        byte[] result = new byte[size];
        for (int i = 0; i < size; i++) {
            result[i] = (byte) i;
        }
        return result;
    }


}
