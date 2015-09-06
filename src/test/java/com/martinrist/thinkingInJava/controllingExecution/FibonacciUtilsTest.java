package com.martinrist.thinkingInJava.controllingExecution;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FibonacciUtilsTest {

    private FibonacciUtils fg = new FibonacciUtils();

    @Test
    public void test_CanCreateNewFibonacciUtils() {
        assertThat(fg, notNullValue());
    }

    @Test
    public void test_GetFibs_GeneratingLessThanZeroFibs_ThrowsIAE() {
        try {
            fg.getFibs(-1);
            fail("Attempting to generate less than zero fibs should throw IAE");
        } catch (IllegalArgumentException iae) {
            // expected behaviour
        }
    }

    @Test
    public void test_GetFibs_GeneratingZeroFibs_ReturnsEmptyCollection() {
        assertThat(fg.getFibs(0), emptyCollectionOf(BigInteger.class));
    }

    @Test
    public void test_GetFibs_GeneratingSingleFib_ReturnsSingleItemCollectionWithCorrectValue() {
        List<BigInteger> fibs = fg.getFibs(1);
        assertThat(fibs, hasSize(1));
        assertThat(fibs, contains(BigInteger.ZERO));
    }

    @Test
    public void test_GetFibs_GeneratingTwoFibs_ReturnsTwoItemCollectionWithCorrectValues() {
        List<BigInteger> fibs = fg.getFibs(2);
        assertThat(fibs, hasSize(2));
        assertThat(fibs, contains(BigInteger.ZERO, BigInteger.ONE));
    }

    @Test
    public void test_GetFibs_GeneratingTenFibs_ReturnsTenItemCollectionWithCorrectValues() {
        List<BigInteger> fibs = fg.getFibs(10);

        List<Integer> integerResults = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        List<BigInteger> expected = integerResults.stream().map(BigInteger::valueOf).collect(Collectors.toList());

        assertThat(fibs, hasSize(10));
        assertThat(fibs, is(expected));
    }

    @Test
    public void test_GetFibs_LastFibFromGetFibs_MatchesResultFromGetFib() {

        for (int n = 2; n <= 1000; n++) {
            BigInteger fib_n = fg.getFibs(n).get(n - 1);
            assertThat(fib_n, is(fg.getFib(n - 1)));
        }

    }


    @Test
    public void test_GetFib_NegativeArgument_ThrowsIAE() {
        try {
            fg.getFib(-1);
            fail("Attempting to call getFib(n) for negative n should throw IAE");
        } catch (IllegalArgumentException iae) {
            // expected behaviour
        }
    }

    @Test
    public void test_GetFib_TestFirst10Values() {
        assertThat(fg.getFib(0), is(BigInteger.valueOf(0)));
        assertThat(fg.getFib(1), is(BigInteger.valueOf(1)));
        assertThat(fg.getFib(2), is(BigInteger.valueOf(1)));
        assertThat(fg.getFib(3), is(BigInteger.valueOf(2)));
        assertThat(fg.getFib(4), is(BigInteger.valueOf(3)));
        assertThat(fg.getFib(5), is(BigInteger.valueOf(5)));
        assertThat(fg.getFib(6), is(BigInteger.valueOf(8)));
        assertThat(fg.getFib(7), is(BigInteger.valueOf(13)));
        assertThat(fg.getFib(8), is(BigInteger.valueOf(21)));
        assertThat(fg.getFib(9), is(BigInteger.valueOf(34)));
    }



}
