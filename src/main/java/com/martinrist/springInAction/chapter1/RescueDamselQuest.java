package com.martinrist.springInAction.chapter1;

/**
 * Quest that represents rescuing a damsel.
 */
public class RescueDamselQuest implements Quest {

    @Override
    public void embark() {
        System.out.println("Rescuing damsel.");
    }
}
