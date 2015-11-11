package com.martinrist.thinkingInJava.arrays;


public class Holder<T> {

    private T item;

    public Holder(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return (item == null) ? "<null>" : "Holder: " + item.toString();
    }
}
