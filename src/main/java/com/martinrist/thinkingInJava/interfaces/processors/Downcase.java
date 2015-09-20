package com.martinrist.thinkingInJava.interfaces.processors;

public class Downcase extends Processor {

    @Override
    String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
