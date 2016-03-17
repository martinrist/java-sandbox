package com.martinrist.effectiveJava.chapter2.builder;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class NutritionFactsTest {

    @Test
    public void testCreationWithMandatoryPropertiesOnly() {

        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).build();

        assertThat(cocaCola, notNullValue());
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getServings(), is(8));
        assertThat(cocaCola.getCalories(), is(0));
        assertThat(cocaCola.getCarbohydrate(), is(0));
        assertThat(cocaCola.getFat(), is(0));
        assertThat(cocaCola.getSodium(), is(0));
    }

    @Test
    public void testCreationWithSingleOptionalProperty() {

        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).build();

        assertThat(cocaCola, notNullValue());
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getServings(), is(8));
        assertThat(cocaCola.getCalories(), is(100));
        assertThat(cocaCola.getCarbohydrate(), is(0));
        assertThat(cocaCola.getFat(), is(0));
        assertThat(cocaCola.getSodium(), is(0));
    }

    @Test(expected = IllegalStateException.class)
    public void testCreationWithNegativeMandatoryProperty_ThrowsISE() {
        new NutritionFacts.Builder(240, -1).build();
    }

    @Test(expected = IllegalStateException.class)
    public void testCreationWithNegativeOptionalProperty_ThrowsISE() {
        new NutritionFacts.Builder(240, 8).fat(-1).build();
    }
}