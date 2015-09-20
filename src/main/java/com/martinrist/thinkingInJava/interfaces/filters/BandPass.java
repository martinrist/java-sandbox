package com.martinrist.thinkingInJava.interfaces.filters;

public class BandPass extends Filter {

    private double lowCutoff;
    private double highCutoff;

    public BandPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    @Override
    public Waveform process(Waveform input) {

        // Don't do anything for now
        return input;

    }
}
