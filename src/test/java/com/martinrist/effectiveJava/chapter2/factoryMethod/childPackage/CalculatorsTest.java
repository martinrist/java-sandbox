package com.martinrist.effectiveJava.chapter2.factoryMethod.childPackage;

import com.martinrist.effectiveJava.chapter2.factoryMethod.Calculator;
import com.martinrist.effectiveJava.chapter2.factoryMethod.Calculators;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class CalculatorsTest {

    @Test
    public void testCanUsePackagePrivateImplementation() {

        // We can't reference the implementation class directly, because
        // it's package-private and we're in a child package.
        // Calculator calc = new SimpleCalculator();

        // However, we can get it back from the Calculators utility class
        Calculator calc = Calculators.getInstance();

        assertThat(calc, notNullValue());
        assertThat(calc.add(10, 20), is(30));

    }
}
