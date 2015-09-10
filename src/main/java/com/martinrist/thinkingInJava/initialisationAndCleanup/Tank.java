package com.martinrist.thinkingInJava.initialisationAndCleanup;

/**
 * A mutable Tank class, which starts empty and can subsequently be either
 * filled or emptied.
 *
 * The object's finaliser verifies the termination condition that, when
 * destroyed, the Tank must be empty.
 *
 * This class is deliberately mutable, so that we can illustrate the
 * termination condition better.
 */
public class Tank {

    // Newly-creatd tanks are always empty
    // (A Tank is either full or empty, never partially full)
    private boolean full = false;

    public boolean isFull() {
        return full;
    }

    public boolean isEmpty() { return !full; }

    /**
     * Fills an empty tank
     * @throws IllegalStateException if the Tank is already full
     */
    public void fill() throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("Cannot fill an already full tank");
        } else {
            this.full = true;
        }
    }

    /**
     * Empties a full tank
     * @throws IllegalStateException if the Tank is already empty
     */
    public void empty() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot empty an already empty tank");
        } else {
            this.full = false;
        }
    }

}
