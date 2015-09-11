package com.martinrist.thinkingInJava.accessControl;

import java.util.Arrays;

public class ConnectionManager {

    private static final int MAX_SIZE = 5;
    private static Connection[] connections = new Connection[MAX_SIZE];
    private static int firstFreeSlot = 0;

    public static Connection getConnection() {

        if (firstFreeSlot < MAX_SIZE) {
            Connection c = new Connection(firstFreeSlot);
            connections[firstFreeSlot++] = c;
            return c;
        } else {
            return null;
        }
    }

    public static String getConnections() {
        return Arrays.toString(connections);
    }
}
