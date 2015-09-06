package com.martinrist.thinkingInJava.controllingExecution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A class that checks whether or not numbers are prime numbers.
 *
 * For the purposes of this class, we're going to take the following definition of
 * primality from <a href="https://en.wikipedia.org/wiki/Prime_number">Wikipedia</a>:
 *
 * A prime number (or a prime) is a natural number greater than 1 that has no
 * positive divisors other than 1 and itself.
 *
 * So, in particular, negative numbers, zero and 1 are not prime.
 *
 */
public class PrimeUtils {

    /**
     * Tests whether a value is prime, by checking all possible factors up to its
     * square root
     * @param p     The number to be tested
     * @return true if the number is prime, otherwise false
     */
    public boolean isPrime(final int p) {

        if (p < 2) {
            return false;
        }

        if (p == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }

        return true;

    }

    /**
     * Helper method to generate to generate primes less than or equal to a specified
     * number.  Uses the Sieve of Eratosthenes to generate primes
     * @param max The maximum (inclusive) candidate number to be considered prime.
     * @return List of all the primes up to and including max).
     */
    public List<Integer> primesUpTo(int max) {

        Set<Integer> candidates = IntStream.rangeClosed(2, max).boxed().collect(Collectors.toSet());

        for (int mod = 2; mod <= Math.sqrt(max); mod++) {
            for (int i = mod * mod; i <= max; i += mod) {
                candidates.remove(i);
            }
        }
        return new ArrayList<>(candidates);
    }
}
