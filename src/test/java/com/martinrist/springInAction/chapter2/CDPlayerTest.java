package com.martinrist.springInAction.chapter2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc sgtPeppers;

    @Autowired
    private MediaPlayer cdPlayer;

    @Test
    public void testCDShouldNotBeNull() {
        assertThat(sgtPeppers, notNullValue());
    }

    @Test
    public void play() {
        cdPlayer.play();
        assertThat(systemOutRule.getLog(),
                is("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n"));
    }

}
