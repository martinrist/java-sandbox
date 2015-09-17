package com.martinrist.thinkingInJava.polymorphism;

import org.junit.Test;

import java.awt.*;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

public class AlertStatusTest {

    private AlertStatus greenAlert = new GreenAlert();
    private AlertStatus yellowAlert = new YellowAlert();
    private AlertStatus redAlert = new RedAlert();

    @Test
    public void test_IncreaseGreenAlert_GivesYellowAlert() {
        assertThat(greenAlert.increase(), instanceOf(YellowAlert.class));
    }


    @Test
    public void test_IncreaseYellowAlert_GivesRedAlert() {
        assertThat(yellowAlert.increase(), instanceOf(RedAlert.class));
    }

    @Test
    public void test_IncreaseRedAlert_GivesRedAlert() {
        assertThat(redAlert.increase(), instanceOf(RedAlert.class));
    }

    @Test
    public void test_DecreaseRedAlert_GivesYellowAlert() {
        assertThat(redAlert.decrease(), instanceOf(YellowAlert.class));
    }

    @Test
    public void test_DecreaseYellowAlert_GivesGreenAlert() {
        assertThat(yellowAlert.decrease(), instanceOf(GreenAlert.class));
    }

    @Test
    public void test_DecreaseGreenAlert_GivesGreenAlert() {
        assertThat(greenAlert.decrease(), instanceOf(GreenAlert.class));
    }

    @Test
    public void test_IncreaseRedAlert_ReturnsSameObject() {
        assertThat(redAlert.increase(), sameInstance(redAlert));
    }

    @Test
    public void test_DecreaseGreenAlert_ReturnsSameObject() {
        assertThat(greenAlert.decrease(), sameInstance(greenAlert));
    }

    @Test
    public void test_AllAlertsGiveCorrectColour() {

        assertThat(greenAlert.getColour(), is(Color.GREEN));
        assertThat(yellowAlert.getColour(), is(Color.YELLOW));
        assertThat(redAlert.getColour(), is(Color.RED));

    }

}
