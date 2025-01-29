package com.example.platefulpalate;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipePageActivity extends AppCompatActivity {

    RecyclerView recipeRecyclerView;
    ExpandableListView expandableListView;
    List<Recipe> recipeList;
    List<String> recipeTitles;
    HashMap<String, List<String>> recipeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_page);

        recipeRecyclerView = findViewById(R.id.recipeRecyclerView);
        expandableListView = findViewById(R.id.expandableListView);

        setupRecipes();
        setupRecyclerView();
        setupExpandableListView();

    }

    private void setupRecipes() {
        recipeList = new ArrayList<>();
        recipeTitles = new ArrayList<>();
        recipeDetails = new HashMap<>();

        // Recipe 1: Pancakes
        List<String> ingredients1 = new ArrayList<>();
        ingredients1.add("1 cup flour");
        ingredients1.add("2 eggs");
        ingredients1.add("1/2 cup sugar");
        ingredients1.add("1 cup milk");
        ingredients1.add("2 tbsp butter");

        List<String> steps1 = new ArrayList<>();
        steps1.add("Mix flour, sugar, eggs, and milk in a bowl.");
        steps1.add("Heat a pan with butter.");
        steps1.add("Pour batter into the pan, cook until bubbles form.");
        steps1.add("Flip the pancake and cook until golden.");
        steps1.add("Serve with syrup or fruits.");

        recipeList.add(new Recipe("Pancakes", R.drawable.pancakes, ingredients1, steps1));
        recipeTitles.add("Pancakes");
        recipeDetails.put("Pancakes", steps1);

        // Recipe 2: Spaghetti
        List<String> ingredients2 = new ArrayList<>();
        ingredients2.add("200g spaghetti");
        ingredients2.add("150g ground beef");
        ingredients2.add("2 tomatoes");
        ingredients2.add("1 onion");
        ingredients2.add("2 cloves garlic");

        List<String> steps2 = new ArrayList<>();
        steps2.add("Cook spaghetti according to package instructions.");
        steps2.add("Sauté onions and garlic until fragrant.");
        steps2.add("Add ground beef, cook until browned.");
        steps2.add("Add chopped tomatoes, simmer for 15 minutes.");
        steps2.add("Combine spaghetti with sauce and serve.");

        recipeList.add(new Recipe("Spaghetti Bolognese", R.drawable.spaghetti, ingredients2, steps2));
        recipeTitles.add("Spaghetti Bolognese");
        recipeDetails.put("Spaghetti Bolognese", steps2);


        // Recipe 3: Salad
        List<String> ingredients3 = new ArrayList<>();
        ingredients3.add("1 cup lettuce");
        ingredients3.add("1/2 cup cherry tomatoes");
        ingredients3.add("1/4 cup cucumbers");
        ingredients3.add("2 tbsp olive oil");
        ingredients3.add("Salt and pepper");

        List<String> steps3 = new ArrayList<>();
        steps3.add("Wash and chop the vegetables.");
        steps3.add("Mix them in a bowl.");
        steps3.add("Drizzle olive oil, add salt and pepper.");
        steps3.add("Toss and serve fresh.");

        recipeList.add(new Recipe("Salad", R.drawable.salad, ingredients3, steps3));
        recipeTitles.add("Salad");
        recipeDetails.put("Salad", steps3);

        // Recipe 4: Fried Rice
        List<String> ingredients4 = new ArrayList<>();
        ingredients4.add("1 cup cooked rice");
        ingredients4.add("1 egg");
        ingredients4.add("1/2 cup mixed vegetables");
        ingredients4.add("2 tbsp soy sauce");
        ingredients4.add("1 tbsp sesame oil");

        List<String> steps4 = new ArrayList<>();
        steps4.add("Heat sesame oil in a pan.");
        steps4.add("Scramble the egg and set aside.");
        steps4.add("Sauté mixed vegetables until tender.");
        steps4.add("Add rice and soy sauce, mix well.");
        steps4.add("Add scrambled eggs, stir, and serve.");

        recipeList.add(new Recipe("Fried Rice", R.drawable.fried_rice, ingredients4, steps4));
        recipeTitles.add("Fried Rice");
        recipeDetails.put("Fried Rice", steps4);

        // Recipe 5: Pizza
        List<String> ingredients5 = new ArrayList<>();
        ingredients5.add("1 pizza base");
        ingredients5.add("1/2 cup tomato sauce");
        ingredients5.add("1 cup shredded cheese");
        ingredients5.add("Toppings: olives, bell peppers, pepperoni");

        List<String> steps5 = new ArrayList<>();
        steps5.add("Preheat the oven to 200°C (400°F).");
        steps5.add("Spread tomato sauce over the pizza base.");
        steps5.add("Sprinkle shredded cheese evenly.");
        steps5.add("Add your favorite toppings.");
        steps5.add("Bake for 12-15 minutes until golden.");

        recipeList.add(new Recipe("Pizza", R.drawable.pizza, ingredients5, steps5));
        recipeTitles.add("Pizza");
        recipeDetails.put("Pizza", steps5);
    }

    private void setupRecyclerView() {
        RecipeAdapter adapter = new RecipeAdapter(this, recipeList);
        recipeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recipeRecyclerView.setAdapter(adapter);
    }

    private void setupExpandableListView() {
        ExpandableListAdapter adapter = new ExpandableListAdapter(this, recipeTitles, recipeDetails);
        expandableListView.setAdapter(adapter);
    }
}
