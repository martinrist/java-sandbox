package com.martinrist.effectiveJava.chapter2.builder;

/**
 * An example of the 'Builder' pattern as an alternative to
 * @see NutritionFactsWithTelescopingConstructorPattern or
 * @see NutritionFactsWithJavaBeansPattern */
public class NutritionFacts {

    private final int servingSize;       // required
    private final int servings;          // required
    private final int calories;          // optional
    private final int fat;               // optional
    private final int sodium;            // optional
    private final int carbohydrate;      // optional

    public static class Builder implements com.martinrist.effectiveJava.chapter2.builder.Builder<NutritionFacts> {

        // Required parameters - set in the builder's constructor
        private final int servingSize;
        private final int servings;

        // Optional parameters with default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build() {
            NutritionFacts nutritionFacts = new NutritionFacts(this);
            validateConstraints(nutritionFacts);
            return nutritionFacts;
        }

        private void validateConstraints(NutritionFacts nutritionFacts) {
            validatePositive("servingSize", nutritionFacts.servingSize);
            validatePositive("servings", nutritionFacts.servings);
            validatePositive("calories", nutritionFacts.calories);
            validatePositive("carbohydrate", nutritionFacts.carbohydrate);
            validatePositive("fat", nutritionFacts.fat);
            validatePositive("sodium", nutritionFacts.sodium);
        }

        private void validatePositive(String name, int value) {
            if (value < 0) {
                throw new IllegalStateException("Property '" + name + "' should be positive.  Supplied value = " + value);
            }
        }

    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
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
