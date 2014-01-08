package com.martinrist.numberClassifier;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestPerfectNumberClassifier {

    @Test
    public void testIs1AFactorOf10() {
        PerfectNumberClassifier c = new PerfectNumberClassifier(10);
        assertTrue(c.isFactor(1));
    }

    @Test
    public void testFactorsFor6() {

        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 6));
        PerfectNumberClassifier c = new PerfectNumberClassifier(6);
        assertThat(c.getFactors(), is(expected));
    }


}
