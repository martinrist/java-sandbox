package com.martinrist.thinkingInJava.interfaces.filters;

public class Filter {

    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {

        input.appendFilter(this);
        return input;
    }

    @Override
    public String toString() {
        return name();
    }
}
