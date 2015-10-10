package com.martinrist.thinkingInJava.typeInfo.pets;

public class Individual {

    private static int next_id;

    private final int id;
    private String name;

    public Individual() {
        this.id = next_id++;
    }

    public Individual(String name) {
        this();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        if (name == null) {
            return this.getClass().getSimpleName();
        } else {
            return name;
        }
    }
}
