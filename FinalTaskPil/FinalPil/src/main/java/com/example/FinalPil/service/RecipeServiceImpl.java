package com.example.FinalPil.service;

import com.example.FinalPil.model.Recipe;
import com.example.FinalPil.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Recipe saveRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }


}
