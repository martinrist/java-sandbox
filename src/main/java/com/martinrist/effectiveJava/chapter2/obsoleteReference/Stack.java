package com.martinrist.effectiveJava.chapter2.obsoleteReference;

import java.util.EmptyStackException;

/**
 * Example Stack implementation that 'manages' its own memory.
 * <p>
 * The object references in the elements[] array are the storage pool.
 */
public class Stack {

    private Object[] elements;
    private int size;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        if (size >= elements.length) {
            throw new IllegalStateException();
        } else {
            elements[size++] = e;
        }
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            Object result = elements[size--];
            // Note how we have to null out the reference to avoid a memory leak;
            elements[size] = null;
            return result;
        }

    }
}
