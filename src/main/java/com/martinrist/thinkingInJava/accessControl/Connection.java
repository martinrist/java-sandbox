package com.martinrist.thinkingInJava.accessControl;

/**
 * Class that represents a 'Connection' that must be obtained from a
 * 'Connection Manager'.
 */
public class Connection {

    private int id;

    Connection(int id) {
        // private constructor to prevent direct instantiation
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Connection " + getId();
    }
}
