package com.martinrist.thinkingInJava.interfaces.processors;

public interface Processor {

    public String name();
    Object process(Object input);

}
