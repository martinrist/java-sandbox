package com.martinrist.thinkingInJava.containers;

import java.util.LinkedList;

/**
 * Stack class, created from a LinkedList via basic delegation.
 * From net.mindview.util.Stack class provided with code samples from
 * 'Thinking in Java'.
 */
public class Stack<T> {

    private LinkedList<T> storage = new LinkedList<T>();

    public void push(T v) {
        storage.addFirst(v);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }
}