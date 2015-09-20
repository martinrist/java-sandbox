package com.martinrist.thinkingInJava.interfaces.factories.games;

public class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess();
    }
}
