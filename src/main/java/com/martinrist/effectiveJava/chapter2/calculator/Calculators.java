package com.martinrist.effectiveJava.chapter2.calculator;

public class Calculators {

    public static Calculator newInstance() {
        return new CalculatorImpl();
    }
}
