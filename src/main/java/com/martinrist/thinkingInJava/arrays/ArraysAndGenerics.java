package com.martinrist.thinkingInJava.arrays;

import java.util.Arrays;

public class ArraysAndGenerics {

    public static void main(String[] args) {

        // Cannot create an array of generic classes
        // Holder<Integer>[] arrayOfIntegerHolders = new Holder<Integer>[10];

        // Although it turns out you can declare a reference to one
        Holder<Integer>[] arrayOfIntegerHolders;

        // We can create an array of the raw type...
        Holder[] rawHolderArray = new Holder[10];
        for (int i = 0; i < rawHolderArray.length; i++) {
            rawHolderArray[i] = new Holder<>(i);
        }

        // ... and print it
        System.out.println(Arrays.toString(rawHolderArray));

        // ... and then assign it to the generic reference
        // But we get an 'unchecked' warning
        arrayOfIntegerHolders = (Holder<Integer>[])rawHolderArray;
        System.out.println(Arrays.toString(arrayOfIntegerHolders));

    }
}
