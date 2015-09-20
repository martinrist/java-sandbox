package com.martinrist.thinkingInJava.interfaces.processors;

public class Upcase extends Processor {

    @Override
    String process(Object input) {
        return ((String)input).toUpperCase();
    }
}
