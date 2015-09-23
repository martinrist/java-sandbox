package com.martinrist.thinkingInJava.containers;

import java.util.*;

public class Exercise4 {

    private static final int COLLECTION_SIZE = 10;

    private static String[] fill(String[] array) {
        final ListBackedGenerator<String> g = new ListBackedGenerator<>(Arrays.asList("Darth Vader", "Luke Skywalker", "Han Solo"));
        for (int i = 0; i < array.length; i++) {
            array[i] = g.next();
        }
        return array;
    }

    private static Collection<String> fill(Collection<String> coll) {
        final ListBackedGenerator<String> g = new ListBackedGenerator<>(Arrays.asList("Darth Vader", "Luke Skywalker", "Han Solo"));
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            coll.add(g.next());
        }
        return coll;
    }

    public static void main(String[] args) {

        System.out.println("String[]      : " + Arrays.toString(fill(new String[COLLECTION_SIZE])));

        System.out.println("ArrayList     : " + fill(new ArrayList<>()));
        System.out.println("LinkedList    : " + fill(new LinkedList<>()));
        System.out.println("HashSet       : " + fill(new HashSet<>()));
        System.out.println("TreeSet       : " + fill(new TreeSet<>()));
        System.out.println("LinkedHashSet : " + fill(new LinkedHashSet<>()));

    }
}
