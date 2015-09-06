package com.martinrist.thinkingInJava.controllingExecution;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PrimeUtilsTest {

    private static final int TEST_SIZE = 10000;

    PrimeUtils pu = new PrimeUtils();

    private IntStream firstInts(int n) {
        return IntStream.rangeClosed(1, n);
    }

    @Test
    public void test_CanCreateNewPrimeUtils() {
        assertThat(pu, notNullValue());
    }

    @Test
    public void test_isPrime_ZeroIsNotPrime() {
        assertThat(pu.isPrime(0), is(false));
    }

    @Test
    public void test_isPrime_NegativeNumbers_AreNotPrime() {
        int[] testNumbers = {-1, -2, -3, -4, -5, -7, -9};
        for (int x : testNumbers) {
            assertThat(pu.isPrime(x), is(false));
        }
    }

    @Test
    public void test_isPrime_OneIsNotPrime() {
        assertThat(pu.isPrime(1), is(false));
    }

    @Test
    public void test_isPrime_TwoIsPrime() {
        assertThat(pu.isPrime(2), is(true));
    }

    @Test
    public void test_isPrime_FirstEvenNumbers_AreNotPrime() {

        IntStream first100NonPrimeEvens =
                firstInts(TEST_SIZE).filter(x -> x > 1).map((x -> 2 * x));

        first100NonPrimeEvens.forEach(
                (x -> assertThat(pu.isPrime(x), is(false))));

    }

    @Test
    public void test_isPrime_FirstSquares_AreNotPrime() {
        IntStream firstSquares =
                firstInts(TEST_SIZE).map((x -> x * x));

        firstSquares.forEach(
                (x -> assertThat(pu.isPrime(x), is(false))));

    }


    @Test
    public void test_isPrime_AllNumbersFromSieve_ArePrime() {
        for (int i : pu.primesUpTo(TEST_SIZE)) {
            assertThat(pu.isPrime(i), is(true));
        }
    }

    @Test
    public void test_isPrime_AllNumbersExcludedFromSieve_AreNotPrime() {

        List<Integer> primes = pu.primesUpTo(TEST_SIZE);
        List<Integer> nonPrimes = firstInts(TEST_SIZE).boxed().collect(Collectors.toList());
        nonPrimes.removeAll(primes);

        for (int i : nonPrimes) {
            assertThat(pu.isPrime(i), is(false));
        }

    }



}
