package com.martinrist.springInAction.chapter1;

import java.io.PrintStream;

/**
 * A medieval logger.
 */
public class Minstrel {

    private PrintStream out;

    public Minstrel(PrintStream out) {
        this.out = out;
    }

    public void singBeforeQuest() {
        out.println("Fa la la, the knight is so brave!");
    }

    public void singAfterQuest() {
        out.println("Tee hee hee, the brave knight did embark on a quest!");
    }

}
