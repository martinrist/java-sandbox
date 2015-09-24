package com.martinrist.thinkingInJava.containers;

import java.util.Iterator;

/**
 * Thinking in Java - 'Holding Your Objects' Chapter
 * Exercise 9 - Refactoring innerclasses/Sequence to use Iterator.
 */
public class Exercise9 {

    public static void main(String[] args) {

        Sequence sequence = new Sequence(10);

        for(int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }

        System.out.println("Iterating through sequence using iterator() / hasNext() / next()");
        Iterator<Object> iter = sequence.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Iterating through sequence using foreach syntax");
        for (Object i : sequence) {
            System.out.print(i + " ");
        }


    }

}
