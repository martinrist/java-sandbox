package com.martinrist.effectiveJava.chapter2.factoryMethod;

/**
 * Completely crazy implementation of @see Calculator interface, that uses
 * recursion to implement operations.  Of course, you'd never want to do this,
 * not least because you're bound to get stack overflows for reasonably-sized
 * arguments.
 */
class CrazyRecursiveCalculator implements Calculator {

    @Override
    public int add(int x, int y) {
        if (x < 0 && y < 0) {
            return -(internalAdd(-x, -y));
        } else if (y < 0) {
            return internalAdd(y, x);
        } else {
            return internalAdd(x, y);
        }
    }

    private int internalAdd(int x, int y) {
        assert(y >= 0);

        if (y == 0) {
            return x;
        } else {
            return internalAdd(x + 1, y - 1);
        }
    }

}
