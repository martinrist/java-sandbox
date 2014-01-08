package com.martinrist.numberClassifier;

import java.util.HashSet;
import java.util.Set;

public class PerfectNumberClassifier {

    private int number;
    private Set<Integer> factors = new HashSet<>();

    public PerfectNumberClassifier(int number) {
        this.number = number;
        addFactor(1);
        addFactor(number);

        for (int i = 2; i < number; i++) {
            if (isFactor(i))
                addFactor(i);
        }
    }

    public boolean isFactor(int factor) {
        return number % factor == 0;
    }

    public Set<Integer> getFactors() {
        return factors;
    }

    private void addFactor(int factor) {
        factors.add(factor);
    }
}
