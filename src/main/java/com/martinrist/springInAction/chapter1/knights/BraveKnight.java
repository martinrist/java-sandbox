package com.martinrist.springInAction.chapter1.knights;

/**
 * A braver (and therefore more useful) Knight than @see DamselRescuingKnight.
 * This knights is able to perform any type of @see Quest.
 *
 * The actual quest to be performed is injected at construction time.
 */
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
