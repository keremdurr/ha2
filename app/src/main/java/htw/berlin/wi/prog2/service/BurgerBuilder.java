package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Burger;
import htw.berlin.wi.prog2.domain.DynamicallyComputedBurger;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.PrecomputedBurger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BurgerBuilder {

    private final List<Ingredient> ingredients = new ArrayList<>();

    public BurgerBuilder add(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this; // Die Rückgabe von 'this' ermöglicht Methodenkettung (Fluent Interface).
    }

    public Burger buildPrecomputed() {
        if (ingredients.size() < 2) {
            throw new IllegalBurgerException("Ein gültiger Burger benötigt mindestens zwei Zutaten.");
        }
        double price = ingredients.stream().mapToDouble(Ingredient::getPrice).sum();
        int calories = ingredients.stream().mapToInt(Ingredient::getCalories).sum();
        List<String> ingredientNames = ingredients.stream().map(Ingredient::getName).collect(Collectors.toList());

        ingredients.clear();
        return new PrecomputedBurger(price, calories, ingredientNames);
    }

    public Burger buildDynamicallyComputed() {
        if (ingredients.size() < 2) {
            throw new IllegalBurgerException("Ein gültiger Burger benötigt mindestens zwei Zutaten.");
        }
        Burger burger = new DynamicallyComputedBurger(new ArrayList<>(ingredients));
        ingredients.clear(); // Zutatenliste leeren
        return burger;
    }
}


