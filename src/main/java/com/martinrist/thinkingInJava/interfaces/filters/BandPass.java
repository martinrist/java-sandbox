package com.martinrist.thinkingInJava.interfaces.filters;

public class BandPass extends Filter {

    private double lowCutoff;
    private double highCutoff;

    public BandPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    @Override
    public String name() {
        return super.name() + "[" + lowCutoff + "-" + highCutoff + "]";
    }
}
