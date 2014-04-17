package com.martinrist.sandbox.lang.bigInteger;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BigIntegerTest {

    final BigInteger byteMax = BigInteger.valueOf(Byte.MAX_VALUE);
    final BigInteger byteMaxPlusOne = byteMax.add(BigInteger.ONE);

    @Test
    public void testBigIntegerByteValueExact_ThrowsExceptionIfLosingPrecision() {

        try {
            byte b = byteMaxPlusOne.byteValueExact();
        } catch (ArithmeticException ae) {
            // We're expecting this exception
            return;
        }

        fail("Expected ArithmeticException not thrown");
    }

    @Test
    public void testBigIntegerByteValue_LosesDataIfLosingPrecision() {
        byte b = byteMaxPlusOne.byteValue();
        assertEquals(-128, b);
    }

}