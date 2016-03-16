package com.martinrist.effectiveJava.chapter2.factoryMethod;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class CalculatorsTest {

    private Calculator defaultCalc;

    @Before
    public void setUp() throws Exception {
        defaultCalc = Calculators.getInstance();
    }

    @Test
    public void testWhenNoNameProvided_ReturnsDefaultImplementation() {
        assertThat(defaultCalc, notNullValue());
        assertThat(defaultCalc, instanceOf(SimpleCalculator.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenInvalidNameProvided_ThrowsIAE() {
        retrieve("NotPresent");
    }

    @Test
    public void testCanRegisterMultipleIdenticalProvidersUnderDifferentNames() {
        register("one", defaultCalc);
        register("two", defaultCalc);

        assertThat(retrieve("one"), sameInstance(defaultCalc));
        assertThat(retrieve("two"), sameInstance(defaultCalc));
    }

    @Test
    public void testCanRegisterMultipleNonIdenticalProvidersWithSameClass() {
        register("one", new SimpleCalculator());
        register("two", new SimpleCalculator());

        Calculator one = retrieve("one");
        Calculator two = retrieve("two");

        assertSameClassDifferentInstance(one, defaultCalc);
        assertSameClassDifferentInstance(two, defaultCalc);
        assertSameClassDifferentInstance(one, two);
    }

    private static void assertSameClassDifferentInstance(Calculator first, Calculator second) {
        assertThat(first, not(sameInstance(second)));
        assertThat(first, instanceOf(second.getClass()));
    }

    @Test
    public void testCanRegisterAndRetrieveDifferentImplementation() {
        register("crazy", new CrazyRecursiveCalculator());
        Calculator crazy = retrieve("crazy");

        assertThat(crazy, notNullValue());
        assertThat(crazy, instanceOf(CrazyRecursiveCalculator.class));
    }

    private void register(final String name, final Calculator calc) {
        Calculators.registerCalculator(name, calc);
    }

    private Calculator retrieve(final String name) {
        return Calculators.getInstance(name);
    }
}
