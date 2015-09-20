package com.martinrist.thinkingInJava.interfaces.factories.games;

public class Chess implements Game {

    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}
