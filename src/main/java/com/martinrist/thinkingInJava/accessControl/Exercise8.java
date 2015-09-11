package com.martinrist.thinkingInJava.accessControl;


/**
 * Thinking in Java - 'Access Control' Chapter
 * Exercise 8 - ConnectionManager Class.
 */
public class Exercise8 {

    public static void main(String[] args) {

        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());

        // This should return null because the Connection Manager is full
        System.out.println(ConnectionManager.getConnection());

        System.out.println(ConnectionManager.getConnections());
    }


}
