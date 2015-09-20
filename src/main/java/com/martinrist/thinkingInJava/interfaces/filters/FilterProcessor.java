package com.martinrist.thinkingInJava.interfaces.filters;

import com.martinrist.thinkingInJava.interfaces.processors.Apply;

public class FilterProcessor {

    public static void main(String[] args) {

        Waveform w = new Waveform();

        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);


    }
}
