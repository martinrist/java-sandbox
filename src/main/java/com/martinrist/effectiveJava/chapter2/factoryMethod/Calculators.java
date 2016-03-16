package com.martinrist.effectiveJava.chapter2.factoryMethod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Utility class
 */
public class Calculators {

    private static final Map<String, Calculator> calculators = new ConcurrentHashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "default";

    static { registerCalculator(DEFAULT_PROVIDER_NAME, new SimpleCalculator()); }

    /**
     * Registers a new implementation of the @see Calculator interface, so that
     * it can later be retrieved with @see getInstance().
     * @param name  The name under which the implementation is to be registered.
     * @param calc  The instance to be returned.
     */
    public static void registerCalculator(String name, Calculator calc) {
        calculators.put(name, calc);
    }

    /**
     * Retrieves the 'default' @see Calculator implementation.
     * @return An instance of the 'default' calculator.
     */
    public static Calculator getInstance() {
        return getInstance(DEFAULT_PROVIDER_NAME);
    }

    /**
     * Retrieves the instance of the @see Calculator implementation previously
     * registered under the specified name.
     * @param name  The name used to look up the @see Calculator implementation.
     * @return  An instance of the @see Calculator implementation that was previously
     *              registered under name.
     * @throws NullPointerException if `name` is `null`.
     * @throws IllegalArgumentException if no implementation was registered under `name`.
     */
    public static Calculator getInstance(final String name) {
        if (name == null) {
            throw new NullPointerException("null provider name given");
        }

        Calculator calc = calculators.get(name);

        if (calc == null) {
            throw new IllegalArgumentException("No calculator registered with name: " + name);
        }

        return calc;
    }


}
