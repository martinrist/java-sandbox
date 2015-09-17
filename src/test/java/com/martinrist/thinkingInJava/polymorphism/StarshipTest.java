package com.martinrist.thinkingInJava.polymorphism;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class StarshipTest {

    private Starship s = new Starship("Enterprise");

    private Starship redAlertStarship = new Starship("Death Star");

    @Before
    public void setUp() {
        redAlertStarship.increaseAlertStatus();
        redAlertStarship.increaseAlertStatus();
    }

    @Test
    public void test_newSpaceship_isAtGreenAlert() {
        assertThat(s.getAlertStatus(), instanceOf(GreenAlert.class));
    }

    @Test
    public void test_increasingAlertStatus() {

        s.increaseAlertStatus();
        assertThat(s.getAlertStatus(), instanceOf(YellowAlert.class));

        s.increaseAlertStatus();
        assertThat(s.getAlertStatus(), instanceOf(RedAlert.class));

        s.increaseAlertStatus();
        assertThat(s.getAlertStatus(), instanceOf(RedAlert.class));

    }

    @Test
    public void test_decreasingAlertStatus() {

        redAlertStarship.decreaseAlertStatus();
        assertThat(redAlertStarship.getAlertStatus(), instanceOf(YellowAlert.class));

        redAlertStarship.decreaseAlertStatus();
        assertThat(redAlertStarship.getAlertStatus(), instanceOf(GreenAlert.class));

        redAlertStarship.decreaseAlertStatus();
        assertThat(redAlertStarship.getAlertStatus(), instanceOf(GreenAlert.class));

    }

    @Test
    public void test_resettingAlertStatus() {

        redAlertStarship.resetAlertStatus();
        assertThat(redAlertStarship.getAlertStatus(), instanceOf(GreenAlert.class));
    }

}
