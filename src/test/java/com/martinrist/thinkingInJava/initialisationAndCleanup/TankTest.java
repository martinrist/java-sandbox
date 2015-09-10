package com.martinrist.thinkingInJava.initialisationAndCleanup;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TankTest {

    Tank tank = new Tank();

    @Test
    public void test_GivenNewTank_WhenCreated_IsEmpty() {
        assertTrue(tank.isEmpty());
    }

    @Test
    public void test_GivenNewTank_WhenCreated_IsNotFull() {
        assertFalse(tank.isFull());
    }

    @Test
    public void test_GivenNewTank_WhenFilled_IsFull() {
        tank.fill();
        assertTrue(tank.isFull());
    }

    @Test
    public void test_GivenNewTank_WhenFilled_IsNotEmpty() {
        tank.fill();
        assertFalse(tank.isEmpty());
    }

    @Test
    public void test_GivenEmptyTank_WhenEmptied_ThrowsException() {
        try {
            tank.empty();
            fail("Emptying an empty tank should have thrown an IllegalStateException");
        } catch (IllegalStateException ise) {
            // expected behaviour
        }
    }

    @Test
    public void test_GivenFullTank_WhenFilled_ThrowsException() {
        try {
            tank.fill();
            tank.fill();
            fail("Filling a full tank should have thrown an IllegalStateException");
        } catch (IllegalStateException ise) {
            // expected behaviour
        }
    }

    @Test
    public void test_GivenTwoNewTanks_WhenOneFilled_OtherRemainsEmpty() {

        Tank tank1 = new Tank();
        Tank tank2 = new Tank();

        tank1.fill();
        assertTrue(tank2.isEmpty());

    }


}
