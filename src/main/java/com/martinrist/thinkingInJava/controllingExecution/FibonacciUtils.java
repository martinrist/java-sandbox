package com.martinrist.thinkingInJava.controllingExecution;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class that provides various functions that are of use with Fibonacci
 * numbers.
 *
 * This class defines fib(0) = 0, fib(1) = 1.
 */
public class FibonacciUtils {

    /**
     * The constant value phi, equal to the <a href="https://en.wikipedia.org/wiki/Golden_ratio">Golden Ratio</a> = (1 + sqrt(5)) / 2,
     * as used in the <a href="https://en.wikipedia.org/wiki/Fibonacci_number#Closed-form_expression">closed-form solution of fib(n)</a>.
     */
    public static final double PHI = (1 + Math.sqrt(5)) / 2;

    /**
     * The constant value psi, equal to (1 - the Golden Ratio), also used in the
     * as used in the <a href="https://en.wikipedia.org/wiki/Fibonacci_number#Closed-form_expression">closed-form solution of fib(n)</a>.
     */
    public static final double PSI = 1 - PHI;


    /**
     * Returns the exact value of fib(n).
     * @param n
     * @return The value of fib(n).
     */
    public BigInteger getFib(final int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate fib(n) for negative n");
        }

        if (n == 0 || n == 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger newB = a.add(b);
            a = b;
            b = newB;
        }

        return b;

    }


    /**
     * Returns the value of fib(n)
     *
     */
    public BigInteger getClosedFib(final int n) {

        BigDecimal bigPhiPowN = BigDecimal.valueOf(PHI).pow(n);
        BigDecimal bigPsiPowN = BigDecimal.valueOf(PSI).pow(n);

        BigDecimal numerator = bigPhiPowN.subtract(bigPsiPowN);
        BigDecimal result = numerator.divideToIntegralValue(new BigDecimal(Math.sqrt(5)));

        return result.toBigIntegerExact();

    }



    /**
     * Returns a list of the first n fibonacci numbers, where fib(0) = 0
     * @param n The number of Fib numbers to generate.
     * @return A list of the first n Fibonacci numbers.
     * @throws IllegalArgumentException if n < 0.
     */
    public List<BigInteger> getFibs(final int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n cannot be less than 0");
        }

        List<BigInteger> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            switch (i) {
                case 0:
                case 1:
                    result.add(BigInteger.valueOf(i));
                    break;
                default:
                    result.add(result.get(i-2).add(result.get(i-1)));
            }
        }

        return result;
    }
}
