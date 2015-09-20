package com.martinrist.thinkingInJava.interfaces.factories.games;

public class Games {

    public static void playGame(GameFactory factory) {

        Game g = factory.getGame();

        while (g.move())
            ;
    }

    public static void main(String[] args) {

        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }

}
