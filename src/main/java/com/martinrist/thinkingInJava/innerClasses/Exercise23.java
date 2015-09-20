package com.martinrist.thinkingInJava.innerClasses;

/**
 * Created by mlr on 20/09/15.
 */
public class Exercise23 {

    public static void main(String[] args) {

        A a1 = new A(1);
        A a2 = new A(2);
        A a3 = new A(3);
        A a4 = new A(4);

        B b = new B();

        System.out.println("Setting entries in positions 1 - 4");
        b.setEntry(1, a1.makeU());
        b.setEntry(2, a2.makeU());
        b.setEntry(3, a3.makeU());
        b.setEntry(4, a4.makeU());

        System.out.println("Calling methods in all the U's");
        b.callUsMethods();

        System.out.println("Removing entries in positions 2 and 4");
        b.removeEntry(2);
        b.removeEntry(4);

        System.out.println("Calling methods in all the U's");
        b.callUsMethods();

    }
}
