package com.example.platefulpalate;

import java.util.List;

public class Recipe {
    private String name;
    private int imageResourceId;
    private List<String> ingredients;
    private List<String> steps;

    public Recipe(String name, int imageResourceId, List<String> ingredients, List<String> steps) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }
}
