package com.martinrist.effectiveJava.chapter2;

import com.martinrist.effectiveJava.chapter2.calculator.Calculator;
import com.martinrist.effectiveJava.chapter2.calculator.Calculators;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestCalculator {

    @Test
    public void testCalculator_CanCreateAndUsePrivateImplementationClass() {
        Calculator calc = Calculators.newInstance();
        assertNotNull(calc);
        assertEquals(2, calc.add(1, 1));
    }
}
