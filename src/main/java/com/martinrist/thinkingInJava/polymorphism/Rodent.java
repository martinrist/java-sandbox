package com.martinrist.thinkingInJava.polymorphism;

public abstract class Rodent {

    private String name;

    public Rodent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns a String representing the noise made by the rodent
     * @return String representation of the Rodent's noise.
     */
    public abstract String makeNoise();

    /**
     * Returns a String representing the type of movement made by the rodent
     * @return String representation of the Rodent's movement type.
     */
    public abstract String move();

    @Override
    public String toString() {
        return String.format("%s: %s", getClass().getSimpleName(), getName());
    }
}
