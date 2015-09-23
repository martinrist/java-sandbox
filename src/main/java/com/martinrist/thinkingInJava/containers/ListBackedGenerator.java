package com.martinrist.thinkingInJava.containers;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that sequentially generates items from a list supplied on creation.
 * Once created, the list cannot be modified.
 *
 * Note: Due to the use of a shared mutable counter, this class is not thread-safe.
 *
 */
public class ListBackedGenerator<T> implements Generator<T> {

    private final List<T> items;
    private int index = 0;

    public ListBackedGenerator(List<T> items) {

        if (items.isEmpty()) {
            throw new IllegalArgumentException("Cannot create from an empty list");
        }

        // Defensive copy, otherwise the caller can modify after creation
        this.items = new ArrayList<>(items);
    }

    /**
     * Returns the next string in the list, then resets index to the next position,
     * wrapping round if necessary
     *
     * @return The next string in the list
     */
    public T next() {

        T result = items.get(index);
        index = (index + 1) % items.size();
        return result;

    }

}
