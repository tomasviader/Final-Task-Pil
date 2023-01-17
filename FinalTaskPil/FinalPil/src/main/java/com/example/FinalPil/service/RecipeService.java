package com.example.FinalPil.service;

import com.example.FinalPil.model.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);

    List<Recipe> getRecipes();

    Recipe getRecipeById(Long idRecipe);

    void deleteRecipe(Long id);
}
