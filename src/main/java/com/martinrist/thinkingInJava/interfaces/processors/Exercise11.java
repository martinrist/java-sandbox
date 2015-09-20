package com.martinrist.thinkingInJava.interfaces.processors;

/**
 * Thinking in Java - 'Interfaces' Chapter
 * Exercise 11 - Adapting the CharacterPairSwapper class to the Processor interface.
 **/
public class Exercise11 {

    public static void main(String[] args) {

        CharacterPairSwapper cps = new CharacterPairSwapper();

        Apply.process(new SwapperAdapter(cps), "12345");
        Apply.process(new SwapperAdapter(cps), "abcd");

    }

}
