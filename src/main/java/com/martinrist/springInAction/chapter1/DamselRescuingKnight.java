package com.martinrist.springInAction.chapter1;

/**
 * A very specific kind of Knight, who appears to be only capable of
 * rescuing damsels.
 *
 * Note the tight coupling to @see RescueDamselQuest caused by the explicit
 * reference to the concrete implementation in the constructor.
 */
public class DamselRescuingKnight implements Knight {

    private RescueDamselQuest quest;

    public DamselRescuingKnight(RescueDamselQuest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

}
