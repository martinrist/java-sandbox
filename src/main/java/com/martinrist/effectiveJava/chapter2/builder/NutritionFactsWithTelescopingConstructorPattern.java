package com.martinrist.effectiveJava.chapter2.builder;

/**
 * An example of the 'Telescoping Constructor' pattern, showing why it
 * doesn't scale well for large numbers of optional paramters.
 */
public class NutritionFactsWithTelescopingConstructorPattern {

    private final int servingSize;      // required
    private final int servings;         // required
    private final int calories;         // optional
    private final int fat;              // optional
    private final int sodium;           // optional
    private final int carbohydrate;     // optional

    public NutritionFactsWithTelescopingConstructorPattern(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFactsWithTelescopingConstructorPattern(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFactsWithTelescopingConstructorPattern(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFactsWithTelescopingConstructorPattern(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFactsWithTelescopingConstructorPattern(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }
}
