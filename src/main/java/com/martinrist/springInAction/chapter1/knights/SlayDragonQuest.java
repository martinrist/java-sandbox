package com.martinrist.springInAction.chapter1.knights;

import java.io.PrintStream;

/**
 * Quest that represents the slaying of a dragon.
 */
public class SlayDragonQuest implements Quest {

    private PrintStream out;

    public SlayDragonQuest(PrintStream out) {
        this.out = out;
    }

    @Override
    public void embark() {
        out.println("Slaying dragon.");
    }

}
