package com.martinrist.sandbox.collections;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class CollectionAlgorithmsTest {

    private List<String> stringList = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @Test
    public void testShuffle_ResultContainsSameElementsAsOriginal() {
        List<String> original = new ArrayList<>(stringList);
        Collections.shuffle(stringList);

        System.out.println("Original list: " + original.toString());
        System.out.println("Shuffled list: " + stringList.toString());

        for (String s : original) {
            assertTrue(stringList.contains(s));
        }

    }
}
