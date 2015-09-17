package com.martinrist.thinkingInJava.polymorphism;

public class Gerbil extends Rodent {

    public Gerbil() {
        this("Gerry");
    }

    public Gerbil(String name) {
        super(name);
        System.out.println("Initialising Gerbil(" + name + ")");
    }

    @Override
    public String makeNoise() {
        // Apparently, gerbils can make a 'thumping' noise.  Who knew?
        return "Thump";
    }

    @Override
    public String move() {
        return "Scamper";
    }
}
