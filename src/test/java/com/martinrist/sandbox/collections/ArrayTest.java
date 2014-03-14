package com.martinrist.sandbox.collections;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayTest {

    String[] stringArray1 = {"a", "b", "c", "d", "e"};
    String[] stringArray2 = new String[]{"a", "b", "c", "d", "e"};
    int[] intArray = new int[]{1, 2, 3, 4, 5};

    @Test
    public void testArraysToString_primitiveArray() {
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(intArray));
    }

    @Test
    public void testArraysToString_referenceArray() {
        assertEquals("[a, b, c, d, e]", Arrays.toString(stringArray1));
    }

    @Test
    public void testCreateArrayListFromArray() {
        List<String> arrayList = Arrays.asList(stringArray1);
        assertEquals("[a, b, c, d, e]", arrayList.toString());
    }

    @Test
    public void testCreateArrayListFromArray_AddElementThrowsUnsupportedOperationException() {
        List<String> arrayList = Arrays.asList(stringArray1);
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
        assertTrue(Arrays.asList(stringArray1).contains("a"));
    }

    @Test
    public void testArrayContainment_arrayDoesNotContainValue() {
        assertFalse(Arrays.asList(stringArray1).contains("x"));
    }

    @Test
    public void testArrayConcatentation_intArray() {
        int[] concatenated = ArrayUtils.addAll(intArray, intArray);
        assertEquals(10, concatenated.length);
    }

    @Test
    public void testArrayConcatentation_StringArray() {
        String[] concatenated = (String[]) ArrayUtils.addAll(stringArray1, stringArray2);
        assertEquals(10, concatenated.length);
    }

    @Test
    public void testJoinArrayContentsWithDelimiter() {
        String result = StringUtils.join(stringArray1, ",");
        assertEquals("a,b,c,d,e", result);
    }

    @Test
    public void testArrayElementRemoval() {
        String[] result = (String[]) ArrayUtils.remove(stringArray1, 0);
        assertEquals("result contains 4 elements", 4, result.length);
        assertFalse("result doesn't contain element 'a'", Arrays.asList(result).contains("a"));
        assertEquals("Original intArray is unchanged in length", 5, intArray.length);
        assertTrue("Original intArray contains element '1'", Arrays.asList(stringArray1).contains("a"));
    }
}
