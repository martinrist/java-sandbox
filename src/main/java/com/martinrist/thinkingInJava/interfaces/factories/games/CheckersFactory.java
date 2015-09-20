package com.martinrist.thinkingInJava.interfaces.factories.games;

public class CheckersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers();
    }
}
