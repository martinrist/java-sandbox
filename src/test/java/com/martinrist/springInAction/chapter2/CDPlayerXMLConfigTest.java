package com.martinrist.springInAction.chapter2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/springInAction/chapter2/application-context-compactDisc-Manual.xml"})
public class CDPlayerXMLConfigTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private CDPlayer cdPlayer;

    @Autowired
    private CDPlayer anotherCdPlayer;

    @Test
    public void testCDShouldNotBeNull() {
        assertThat(cd, notNullValue());
    }

    @Test
    public void play() {
        cdPlayer.play();
        assertThat(systemOutRule.getLog(),
                is("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n"));
    }

    @Test
    public void testBothMediaPlayersContainSameCDInstance() {
        assertThat(cdPlayer.getCd(), sameInstance(anotherCdPlayer.getCd()));
    }


}
