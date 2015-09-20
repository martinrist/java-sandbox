package com.martinrist.thinkingInJava.interfaces;

public abstract class AbstractInstrument implements Instrument {

    @Override
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }

    @Override
    public abstract String toString();
}
