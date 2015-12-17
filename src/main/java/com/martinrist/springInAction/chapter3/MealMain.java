package com.martinrist.springInAction.chapter3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Class that attempts to create and eat a Meal.
 */
public class MealMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MealConfig.class);
        ctx.refresh();
        Meal meal = ctx.getBean(Meal.class);
        meal.eat();

    }
}
