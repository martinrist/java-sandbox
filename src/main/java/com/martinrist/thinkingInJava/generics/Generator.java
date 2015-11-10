package com.martinrist.thinkingInJava.generics;

/**
 * Generic interface to be implemented by any class that can generate
 * objects of type T.
 */
public interface Generator<T> {
    T next();
}
