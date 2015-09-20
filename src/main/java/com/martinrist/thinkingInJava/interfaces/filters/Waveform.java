package com.martinrist.thinkingInJava.interfaces.filters;

import java.util.ArrayList;
import java.util.List;

public class Waveform {

    private static long counter;
    private final long id = counter++;
    private final List<Filter> appliedFilters = new ArrayList<>();

    public void appendFilter(Filter f) {
        appliedFilters.add(f);
    }

    @Override
    public String toString() {
        return "Waveform " + id + " processed by " + appliedFilters;
    }
}
