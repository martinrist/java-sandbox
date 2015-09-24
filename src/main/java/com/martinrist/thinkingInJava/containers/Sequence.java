package com.martinrist.thinkingInJava.containers;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sequence implements Iterable<Object> {

    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SequenceIterator();
    }

    private class SequenceIterator implements Iterator<Object> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return (i < items.length);
        }

        @Override
        public Object next() {
            if (i < items.length) {
                return items[i++];
            } else {
                throw new NoSuchElementException();
            }
        }

    }

}

