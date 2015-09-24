package com.martinrist.thinkingInJava.containers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Thinking in Java - 'Holding Your Objects' Chapter
 * Exercise 15 - Using a Stack to evaluate and execute expressions
 */
public class Exercise15 {

    private static final Pattern TOKEN_PATTERN = Pattern.compile("\\+[\\w\\s]|-");

    public static void main(String[] args) {

        String input = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
        new Exercise15().execute(input);

    }


    private String execute(String input) {

        List<Token<Character>> tokens = parse(input);

        System.out.println("Parsed input string to : " + tokens);

        Stack<Character> stack = new Stack<>();

        for (Token<Character> t : tokens) {
            t.execute(stack);
        }

        return stack.toString();
    }


    private List<Token<Character>> parse(String input) {

        List<Token<Character>> tokens = new ArrayList<>();

        Matcher m = TOKEN_PATTERN.matcher(input);

        while (m.find()) {
            tokens.add(parseToken(m.group()));
        }

        return tokens;
    }


    private Token<Character> parseToken(String tokenString) {

        if ("-".equals(tokenString)) {
            return new RemoveToken<>();
        }

        if (tokenString.length() != 2) {
            throw new IllegalArgumentException("Parse exception - unable to parse token " + tokenString);
        }

        if (!(tokenString.substring(0, 1).equals("+"))) {
            throw new IllegalArgumentException("Parse exception - unable to parse token " + tokenString);
        }

        Character ch = tokenString.charAt(1);
        return new AddToken<>(ch);

    }
}
