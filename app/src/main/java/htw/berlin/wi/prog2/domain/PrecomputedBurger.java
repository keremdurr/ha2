package htw.berlin.wi.prog2.domain;

import java.util.List;

public class PrecomputedBurger implements Burger {
    private final double price;
    private final int calories;
    private final List<String> ingredientNames;

    public PrecomputedBurger(double price, int calories, List<String> ingredientNames) {
        this.price = price;
        this.calories = calories;
        this.ingredientNames = ingredientNames;
    }

    @Override
    public double calculatePrice() {
        return this.price;
    }

    @Override
    public int calculateCalories() {
        return this.calories;
    }

    @Override
    public List<String> getIngredientNames() {
        return this.ingredientNames;
    }
}

