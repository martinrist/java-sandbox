package com.martinrist.thinkingInJava.interfaces.filters;

public class HighPass extends Filter {

    private double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public String name() {
        return super.name() + "[" + cutoff + "]";
    }

}
