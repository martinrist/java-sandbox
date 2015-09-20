package com.martinrist.thinkingInJava.interfaces.filters;

public class HighPass extends Filter {

    private double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {

        // Don't do anything for now
        return input;

    }
}
