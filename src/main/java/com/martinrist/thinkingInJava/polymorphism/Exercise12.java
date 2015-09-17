package com.martinrist.thinkingInJava.polymorphism;

/**
 * Thinking in Java - 'Polymorphism' Chapter
 * Exercise 9 - Exercising Rodents with member instances
 */
public class Exercise12 {

    public static void main(String[] args) {

        // This will show the order of initialisation:
        // - Rodent member instances
        // - Rodent constructor
        // - Mouse member instances
        // - Mouse constructor

        Rodent mickey = new Mouse();
    }

}

