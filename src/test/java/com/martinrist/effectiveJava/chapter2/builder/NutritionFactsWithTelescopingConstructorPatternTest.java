package com.martinrist.effectiveJava.chapter2.builder;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NutritionFactsWithTelescopingConstructorPatternTest {

    @Test
    public void testOptionalValuesAreCorrectlyDefaulted() {
        NutritionFactsWithTelescopingConstructorPattern cocaCola =
                new NutritionFactsWithTelescopingConstructorPattern(240, 8);

        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getServings(), is(8));
        assertThat(cocaCola.getCalories(), is(0));
        assertThat(cocaCola.getFat(), is(0));
        assertThat(cocaCola.getSodium(), is(0));
        assertThat(cocaCola.getCarbohydrate(), is(0));
    }

}