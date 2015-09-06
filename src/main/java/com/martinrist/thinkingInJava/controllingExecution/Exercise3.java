package com.martinrist.thinkingInJava.controllingExecution;

/**
 * Thinking in Java - 'Controlling Execution' Chapter
 * Exercise 3 - Generate random int values, then classify each as >, =, < a
 * second randomly-generated int value.  Continue indefinitely.
 */
public class Exercise3 {

    public static void main(String[] args) {

        RandComparer rc = new RandComparer();

        while (true) {
            System.out.println(rc.compareRand());
        }
    }

}
