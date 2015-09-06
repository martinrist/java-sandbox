package com.martinrist.thinkingInJava.controllingExecution;

/**
 * Thinking in Java - 'Controlling Execution' Chapter
 * Exercise 9 - Find the first 'NUM_FIBS' Fibonacci numbers.
 */
public class Exercise9 {

    private static int NUM_FIBS = 20;

    public static void main(String[] args) {

        System.out.println(new FibonacciUtils().getFibs(NUM_FIBS));

    }


}
