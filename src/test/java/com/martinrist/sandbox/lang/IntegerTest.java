package com.martinrist.sandbox.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IntegerTest {

    @Test
    public void testParseInt_FailsWithNumberFormatException() throws Exception {
        try {
            Integer.parseInt("xyz");
            fail("Expected NumberFormatException was not raised");
        } catch (NumberFormatException e) {
            // expected result
        }
    }

    @Test
    public void testParseInt_NumberWithLeadingZeroWorks() throws Exception {
        assertEquals(1, Integer.parseInt("01"));
    }

    @Test
    public void testParseInt_NumberWithLeadingIsNotInterpretedAsOctal() throws Exception {
        assertEquals(10, Integer.parseInt("010"));
    }


}
