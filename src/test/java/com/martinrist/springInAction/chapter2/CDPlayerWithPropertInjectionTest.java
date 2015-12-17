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
public class CDPlayerWithPropertInjectionTest {

    @Autowired
    private CDPlayerWithPropertyInjection cdPlayerWithPropertyInjection;

    @Test
    public void testAbbeyRoadIsCorrectlyInjected() {
        CompactDisc abbeyRoad = cdPlayerWithPropertyInjection.getCompactDisc();
        assertThat(abbeyRoad.getArtist(), is("The Beatles"));
        assertThat(abbeyRoad.getTitle(), is("Abbey Road"));
    }


}
