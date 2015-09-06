package com.martinrist.sandbox.math;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverflowTest {

    @Test
    public void testIntegerOverflowsSilentlyFromMAX_VALUEtoMIN_VALUE() {
        assertEquals(Integer.MIN_VALUE, Integer.MAX_VALUE + 1);
    }


    @Test
    public void testIntegerDivisionByZeroThrowsArithmeticException() {

        try {
            int i = 1 / 0;
            fail("int division by zero should throw an ArithmeticException");
        } catch (ArithmeticException ae) {
            // expected result
        }
    }

    @Test
    public void testIntegerWrapperDivisionByZeroThrowsArithmeticException() {

        Integer one = Integer.valueOf(1);
        Integer zero = Integer.valueOf(0);

        try {
            Integer wtf = Integer.divideUnsigned(one, zero);
            fail("Integer division by zero should throw an ArithmeticException");
        } catch (ArithmeticException ae) {
            // expected result
        }
    }

    @Test
    public void testLongDivisionByZeroThrowsArithmeticException() {
        try {
            long l = 1L / 0L;
            fail("Long division by zero should throw an ArithmeticException");
        } catch (ArithmeticException ae) {
            // expected result
        }
    }


    @Test
    public void testFloatingPointDivisionByZeroReturnsSpecialValues() {
        assertEquals(Double.POSITIVE_INFINITY, 1.0 / 0.0, 0);
        assertEquals(Double.NEGATIVE_INFINITY, -1.0 / 0.0, 0);
    }


    @Test
    public void testFloatingPointZeroDividedByZeroReturnsNaN() {
        assertEquals(Double.NaN, 0.0 / 0.0, 0);
        assertTrue(Double.isNaN(0.0 / 0.0));
    }


    @Test
    public void testNaNDoesNotEqualNaN() {
        assertFalse(Float.NaN == Float.NaN);
    }
}
