package com.martinrist.effectiveJava.chapter2.builder;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NutritionFactsWithJavaBeansPatternTest {

    private final NutritionFactsWithJavaBeansPattern cocaCola = new NutritionFactsWithJavaBeansPattern();

    @Test
    public void testCanAccessIncompletelyInitialisedObject() {

        // At this point, the object is not completely initialised
        assertThat(cocaCola.getServingSize(), is(-1));
        assertThat(cocaCola.getServings(), is(-1));

        // We can continue to set all the necessary fields using setters
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);

        // Unset optional fields retain their default values
        assertThat(cocaCola.getFat(), is(0));

    }

    @Test
    public void testCanMutatePropertiesOnceSet() {

        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        assertThat(cocaCola.getServingSize(), is(240));

        cocaCola.setServingSize(330);
        assertThat(cocaCola.getServingSize(), is(330));
    }

}