package com.martinrist.thinkingInJava.typeInfo;

/**
 * Thinking in Java - 'Type Information' Chapter
 * Exercise 8 - Class Hierarchy
 */
public class Exercise8 {

    public static void main(String[] args) {

        printClassHierarchyFromObject(new Integer(1));
        System.out.println();

        printClassHierarchyFromObject("Hello World");
        System.out.println();

        printClassHierarchy(ArrayIndexOutOfBoundsException.class);
        System.out.println();

        printClassHierarchy(Object.class);
        System.out.println();

    }


    private static void printClassHierarchyFromObject(Object o) {

        System.out.println("Getting hierarchy of: " + o);
        printClassHierarchy(o.getClass());

    }


    private static void printClassHierarchy(Class<?> c) {
        printClassHierarchy(c, 0);
    }

    private static void printClassHierarchy(Class<?> c, int indent) {

        // c.getSuperclass() returns null when c.equals(Object.class)
        // so this is the recursion termination condition
        if (c == null) return;

        for (int i = 0; i < indent; i++) {
            System.out.print("-");
        }

        System.out.println(c.getCanonicalName());
        printClassHierarchy(c.getSuperclass(), indent + 1);

    }

}
