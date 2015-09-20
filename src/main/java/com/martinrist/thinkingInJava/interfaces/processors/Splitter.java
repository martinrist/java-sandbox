package com.martinrist.thinkingInJava.interfaces.processors;

import java.util.Arrays;

public class Splitter extends Processor {

    @Override
    String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
