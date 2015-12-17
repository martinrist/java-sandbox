package com.martinrist.springInAction.chapter3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Represents a Meal, which initially only consists of a single course, dessert,
 * because that's clearly the best of the lot.
 */
@Component
public class Meal {

    private Dessert dessert;

    @Autowired
    @Qualifier("cold")
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public void eat() {

        System.out.println("Skipping starter and main course");
        System.out.println("Starting dessert");
        dessert.eat();
        System.out.println("Finished dessert");
        System.out.println("Finished meal");

    }


}
