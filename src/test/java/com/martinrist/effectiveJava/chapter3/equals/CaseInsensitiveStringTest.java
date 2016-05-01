package com.martinrist.effectiveJava.chapter3.equals;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CaseInsensitiveStringTest {

    @Test
    public void testEqualsIsReflexive() {
        CaseInsensitiveString cis = new CaseInsensitiveString("polish");
        assertTrue(cis.equals(cis));
    }

    @Test
    public void testEqualsViolatesSymmetry() {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        assertTrue(cis.equals(s));
        assertFalse(s.equals(cis));
    }

}