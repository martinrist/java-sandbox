package com.martinrist.thinkingInJava.interfaces.processors;

public abstract class StringProcessor implements Processor {

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public abstract String process(Object input);

}
