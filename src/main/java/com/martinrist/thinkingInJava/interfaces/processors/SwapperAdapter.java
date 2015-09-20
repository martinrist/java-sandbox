package com.martinrist.thinkingInJava.interfaces.processors;

public class SwapperAdapter implements Processor {

    private final CharacterPairSwapper ss;

    public SwapperAdapter(CharacterPairSwapper ss) {
        this.ss = ss;
    }

    @Override
    public String name() {
        return CharacterPairSwapper.class.getSimpleName();
    }

    @Override
    public String process(Object input) {
        return ss.swapPairs((String) input);
    }
}
