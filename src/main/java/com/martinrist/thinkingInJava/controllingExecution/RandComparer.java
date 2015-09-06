package com.martinrist.thinkingInJava.controllingExecution;

import java.util.Random;

public class RandComparer {

    private Random r = new Random();

    public String compareRand() {

        int x = r.nextInt();
        int y = r.nextInt();

        if (x < y) {
            return (x + " < " + y);
        } else if (x > y) {
            return (x + " > " + y);
        } else {
            return (x + " = " + y);
        }

    }

}
