package com.martinrist.thinkingInJava.interfaces.processors;

public class CharacterPairSwapper {

    public String swapPairs(final String input) {

        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < input.length() - 1; i += 2) {

            char c1 = input.charAt(i);
            char c2 = input.charAt(i+1);

            sb.setCharAt(i, c2);
            sb.setCharAt(i + 1, c1);

        }
        return sb.toString();
    }

}
