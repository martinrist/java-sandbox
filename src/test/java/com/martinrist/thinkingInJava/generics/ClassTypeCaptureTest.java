package com.martinrist.thinkingInJava.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.*;


import static org.junit.Assert.*;

public class ClassTypeCaptureTest {

    @Test
    public void testBuildingCTTIsInstanceTests() {
        ClassTypeCapture<Building> ctt = new ClassTypeCapture<>(Building.class);
        assertThat(ctt.f(new Building()), is(true));
        assertThat(ctt.f(new House()), is(true));
    }

    @Test
    public void testHouseCTTIsInstanceTests() {
        ClassTypeCapture<House> ctt = new ClassTypeCapture<>(House.class);
        assertThat(ctt.f(new Building()), is(false));
        assertThat(ctt.f(new House()), is(true));
    }

    @Test
    public void testGivenNewCTTWithoutTypeConfiguration_WhenCreateNewCalled_ThrowsIAE() {

        ClassTypeCapture<?> ctt = new ClassTypeCapture<>(null);

        try {
            ctt.createNew("foo");
        } catch (IllegalArgumentException iae) {
            // Expected behaviour
            return;
        } catch (Exception e) {
            fail("Expected IllegalArgumentException was not thrown");
        }
        fail("Expected IllegalArgumentException was not thrown");

    }


    @Test
    public void testGivenNewCTTWithTypeConfiguration_WhenCreateNewCalledForValidTypename_ReturnsObject() throws Exception {

        ClassTypeCapture<?> ctt = new ClassTypeCapture<>(null);
        ctt.addType("house", House.class);
        ctt.addType("building", House.class);

        assertThat(ctt.createNew("house"), instanceOf(House.class));
        assertThat(ctt.createNew("house"), instanceOf(Building.class));
        assertThat(ctt.createNew("building"), instanceOf(Building.class));

    }

}