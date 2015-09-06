package com.martinrist.thinkingInJava.controllingExecution;

/**
 * Thinking in Java - 'Controlling Execution' Chapter
 * Exercise 2 - Generate 25 random int values, then classify each as >, =, < a
 * second randomly-generated int value.
 */
public class Exercise2 {

    public static void main(String[] args) {

        RandComparer rc = new RandComparer();

        for (int i = 1; i <= 25; i++) {
            System.out.println(rc.compareRand());
        }
    }

}
