package com.martinrist.thinkingInJava.polymorphism;

public class Mouse extends Rodent {

    private Member mouseMember1 = new Member("Mouse Member 1");
    private Member mouseMember2 = new Member("Mouse Member 2");

    public Mouse() {
        this("Mickey");
    }

    public Mouse(String name) {
        super(name);
        System.out.println("Initialising Mouse(" + name + ")");
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
