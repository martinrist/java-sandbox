package com.martinrist.thinkingInJava.polymorphism;

public class Hamster extends Rodent {

    public Hamster() {
        this("Humphrey");
    }

    public Hamster(String name) {
        super(name);
    }

    @Override
    public String makeNoise() {

        return "Chatter";
    }

    @Override
    public String move() {
        return "Run around in a wheel";
    }
}
