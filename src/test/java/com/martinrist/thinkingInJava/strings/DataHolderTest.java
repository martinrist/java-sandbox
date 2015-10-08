package com.martinrist.thinkingInJava.strings;

import org.junit.Test;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class DataHolderTest {

    DataHolder testObject;

    @Test
    public void test_Creation_WithSimpleIntValues() {

        testObject = new DataHolder("1 2 3 4 5");

        assertThat(testObject.getIntValue(), is(1));
        assertThat(testObject.getLongValue(), is(2L));
        assertThat(testObject.getFloatValue(), is(3.0F));
        assertThat(testObject.getDoubleValue(), is(4.0));
        assertThat(testObject.getStringValue(), is("5"));

    }

    @Test
    public void test_Creation_WithComplexValues() {

        testObject = new DataHolder("1 2000000000000 3.14159 4.1234567 ABRACADABRA");

        assertThat(testObject.getIntValue(), is(1));
        assertThat(testObject.getLongValue(), is(2000000000000L));
        assertThat(testObject.getFloatValue(), is(3.14159F));
        assertThat(testObject.getDoubleValue(), is(4.1234567));
        assertThat(testObject.getStringValue(), is("ABRACADABRA"));

    }

    @Test
    public void test_Creation_WithEmptyString_ThrowsNSEE() {

        try {
            testObject = new DataHolder("");
            fail("Should have thrown NoSuchElementException");
        } catch (NoSuchElementException nsee) {
            // expected behaviour
        }

    }

    @Test
    public void test_Creation_WithInvalidInteger_ThrowsInputMismatchException() {

        try {
            testObject = new DataHolder("IAMNOTANINTEGER");
            fail("Should have thrown InputMismatchException");
        } catch (InputMismatchException ime) {
            // expected behaviour
        }
    }


}