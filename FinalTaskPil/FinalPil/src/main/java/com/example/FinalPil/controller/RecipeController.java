package com.example.FinalPil.controller;

import com.example.FinalPil.model.Recipe;
import com.example.FinalPil.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/recipes")
@RequiredArgsConstructor
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @PostMapping
    public Recipe saveRecipe(@RequestBody Recipe recipe){
        return recipeService.saveRecipe(recipe);


    }
}
