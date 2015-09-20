package com.martinrist.thinkingInJava.interfaces.filters;

public class LowPass extends Filter {

    private double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public String name() {
        return super.name() + "[" + cutoff + "]";
    }
}
