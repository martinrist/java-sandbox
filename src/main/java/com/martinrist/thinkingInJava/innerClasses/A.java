package com.martinrist.thinkingInJava.innerClasses;

/**
 * Class 'A' as required for Exercise 23 of 'Thinking in Java' chapter
 * 'Inner Classes'.
 */
public class A {

    private int id;

    public A(final int id) {
        this.id = id;
    }

    public U makeU() {

        return new U() {
            @Override
            public void method1() {
                System.out.println("In U.method1() as returned from A.makeU() for A.id = " + id);
            }

            @Override
            public void method2() {
                System.out.println("In U.method2() as returned from A.makeU() for A.id = " + id);
            }

            @Override
            public void method3() {
                System.out.println("In U.method3() as returned from A.makeU() for A.id = " + id);
            }

            @Override
            public String toString() {
                return "U returned from A.makeU() for A.id = " + id;
            }


        };
    }

    @Override
    public String toString() {
        return String.format("A [id = %d]", id);
    }
}
