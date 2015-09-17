package com.martinrist.thinkingInJava.polymorphism;

public abstract class Rodent {

    private String name;
    private Member rodentMember1 = new Member("Rodent Member 1");
    private Member rodentMember2 = new Member("Rodent Member 2");

    public Rodent(String name) {
        System.out.println("Initialising Rodent(" + name + ")");
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
