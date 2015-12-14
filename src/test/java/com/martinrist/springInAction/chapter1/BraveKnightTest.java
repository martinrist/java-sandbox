package com.martinrist.springInAction.chapter1;

import com.martinrist.springInAction.chapter1.BraveKnight;
import com.martinrist.springInAction.chapter1.Quest;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BraveKnightTest {

    @Test
    public void testQuestEmbarkIsCalled() {

        Quest mockQuest = mock(Quest.class);

        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();

    }


}