package com.martinrist.thinkingInJava.io;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ByteArrayOutputStreamTest {

    private ByteArrayOutputStream testObject = new ByteArrayOutputStream();

    @Test
    public void test_GivenNewEmptyStream_WhenWrittenToByteArray_ThenReturnsEmptyArray() {
        byte[] array = testObject.toByteArray();
        assertThat(ArrayUtils.toObject(array), emptyArray());
    }

    @Test
    public void test_GivenNewEmptyStream_WhenWrittenToString_ThenReturnsEmptyString() {
        String result = testObject.toString();
        assertThat(result, isEmptyString());
    }

    @Test
    public void test_GivenStreamWithContents_WhenWrittenToByteArray_ThenReturnsExpectedContents() {
        testObject.write(42);
        testObject.write(15);
        testObject.write(66);

        byte[] array = testObject.toByteArray();

        assertThat(ArrayUtils.toObject(array), arrayWithSize(3));
        assertThat(ArrayUtils.toObject(array), arrayContaining((byte) 42, (byte) 15, (byte) 66));
    }

    @Test
    public void test_GivenStreamWithContents_WhenResetCalled_ThenSizeResetsCorrectly() {
        testObject.write(42);
        assertThat(testObject.size(), is(1));
        testObject.reset();
        assertThat(testObject.size(), is(0));
        assertThat(testObject.toString(), isEmptyString());
    }
}
