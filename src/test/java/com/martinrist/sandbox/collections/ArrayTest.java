package com.martinrist.sandbox.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayTest {

    String[] aArray = new String[5];
    String[] bArray = {"a", "b", "c", "d", "e"};
    String[] cArray = new String[]{"a", "b", "c", "d", "e"};
    int[] intArray = new int[]{1, 2, 3, 4, 5};

    @Test
    public void testArraysToString_primitiveArray() {
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(intArray));
    }

    @Test
    public void testArraysToString_referenceArray() {
        assertEquals("[a, b, c, d, e]", Arrays.toString(bArray));
    }

    @Test
    public void testCreateArrayListFromArray() {
        List<String> arrayList = Arrays.asList(bArray);
        assertEquals("[a, b, c, d, e]", arrayList.toString());
    }

    @Test
    public void testCreateArrayListFromArray_AddElementThrowsUnsupportedOperationException() {
        List<String> arrayList = Arrays.asList(bArray);
        try {
            arrayList.add("foo");
        } catch (UnsupportedOperationException uoe) {
            return;
            // Expected result - arrayList is immutable
        }

        fail("Should not be able to add element to result of Arrays.asList()");
    }

    @Test
    public void testArrayContainment_arrayContainsValue() {
        assertTrue(Arrays.asList(bArray).contains("a"));
    }

    @Test
    public void testArrayContainment_arrayDoesNotContainValue() {
        assertFalse(Arrays.asList(bArray).contains("x"));
    }
}
