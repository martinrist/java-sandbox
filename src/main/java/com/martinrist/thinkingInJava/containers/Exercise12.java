package com.martinrist.thinkingInJava.containers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Thinking in Java - 'Holding Your Objects' Chapter
 * Exercise 12 - Using ListIterator to reverse list
 */
public class Exercise12 {

    public static void main(String[] args) {

        List<Integer> ints = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        System.out.println("Original list : " + ints);

        ListIterator<Integer> iter = ints.listIterator(ints.size());

        List<Integer> reversed = new ArrayList<>();

        while (iter.hasPrevious()) {
            reversed.add(iter.previous());
        }

        System.out.println("Reversed list : " + reversed);

    }




}
