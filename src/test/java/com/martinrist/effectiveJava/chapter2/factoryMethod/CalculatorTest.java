package com.martinrist.effectiveJava.chapter2.factoryMethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CalculatorTest {

    @Parameterized.Parameters
    public static Collection<Calculator> data() {
        return Arrays.asList(new SimpleCalculator(), new CrazyRecursiveCalculator());
    }

    private Calculator calc;

    public CalculatorTest(Calculator calc) {
        this.calc = calc;
    }


    @Test
    public void testOnePlusOneEqualsTwo() {
        assertThat(calc.add(1, 1), is(2));
    }

    @Test
    public void testZeroPlusOneEqualsOne() {
        assertThat(calc.add(0, 1), is(1));
    }

    @Test
    public void testOnePlusZeroEqualsOne() {
        assertThat(calc.add(1, 0), is(1));
    }

    @Test
    public void testMinusOnePlusOneEqualsZero() {
        assertThat(calc.add(-1, 1), is(0));
    }

    @Test
    public void testOnePlusMinusOneEqualsZero() {
        assertThat(calc.add(1, -1), is(0));
    }

    @Test
    public void testMinusOnePlusMinusOneEqualsMinusTwo() {
        assertThat(calc.add(-1, -1), is(-2));
    }

}
