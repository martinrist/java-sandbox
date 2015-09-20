package com.martinrist.thinkingInJava.interfaces.filters;

public class LowPass extends Filter {

    private double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {

        // Don't do anything for now
        return input;

    }
}
