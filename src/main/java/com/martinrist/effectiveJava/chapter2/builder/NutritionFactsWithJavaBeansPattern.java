package com.martinrist.effectiveJava.chapter2.builder;

/**
 * An example of the 'JavaBeans' pattern as an alternative to
 * @see NutritionFactsWithTelescopingConstructorPattern */
public class NutritionFactsWithJavaBeansPattern {

    // Note that these can no longer be final
    private int servingSize = -1;      // required
    private int servings = -1;         // required
    private int calories = 0;          // optional
    private int fat = 0;               // optional
    private int sodium = 0;            // optional
    private int carbohydrate = 0;      // optional

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
