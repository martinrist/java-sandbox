package com.martinrist.thinkingInJava.polymorphism;

public class Mouse extends Rodent {

    public Mouse() {
        this("Mickey");
    }

    public Mouse(String name) {
        super(name);
    }

    @Override
    public String makeNoise() {
        return "Squeak";
    }

    @Override
    public String move() {
        return "Scurry";
    }
}
