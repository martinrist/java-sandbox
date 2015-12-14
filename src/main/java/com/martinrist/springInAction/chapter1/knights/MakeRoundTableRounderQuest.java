package com.martinrist.springInAction.chapter1.knights;

import java.io.PrintStream;

/**
 * Quest that represents making a round table even rounder.
 */
public class MakeRoundTableRounderQuest implements Quest {

    private PrintStream out;

    public MakeRoundTableRounderQuest(PrintStream out) {
        this.out = out;
    }

    @Override
    public void embark() {
        out.println("Making round table even rounder.");
    }
}
