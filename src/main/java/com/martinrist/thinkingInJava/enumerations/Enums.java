package com.martinrist.thinkingInJava.enumerations;

import java.util.Random;

/**
 * Utility class for Enums.
 */
public class Enums {

    // Don't use hard-coded seed in any real-world scenarios - obviously!
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }

}
