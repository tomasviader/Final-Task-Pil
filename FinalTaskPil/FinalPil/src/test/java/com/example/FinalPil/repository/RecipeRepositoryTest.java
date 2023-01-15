package com.example.FinalPil.repository;

import com.example.FinalPil.model.Recipe;
import com.example.FinalPil.model.Zone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    RecipeRepository recipeRepository;


    Recipe recipe1 = Recipe.builder()
            .id(1L)
            .recipeName("Paper Lamp")
            .material("paper")
            .steps("cut the paper into strips and voila!")
            .build();

    Recipe recipe2 = Recipe.builder()
            .id(2L)
            .recipeName("Pot for aquatic plants")
            .material("glass")
            .steps("All you have to do is remove the label, wash it and voila!")
            .build();

    @Test
    void aNewRecipeShouldBeCreated(){

        Recipe savedRecipe = recipeRepository.save(recipe1);

        assertNotNull(savedRecipe);
    }

    @Test
    void weShouldGetAllRecipes(){

        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);

        ArrayList<Recipe> saveRecipes = new ArrayList<>();
        saveRecipes.add(recipe1);
        saveRecipes.add(recipe2);

        assertEquals(saveRecipes.get(1).getRecipeName(), recipe2.getRecipeName());
    }
}
