package com.example.FinalPil.controller;

import com.example.FinalPil.model.Recipe;
import com.example.FinalPil.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Recipe> getRecipes(){
        return recipeService.getRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id){
        return recipeService.getRecipeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
        return "Recipe deleted succefully.";
    }

    @GetMapping("/material/{material}")
    public Recipe findByMaterial(@PathVariable String material){
        return recipeService.findByMaterial(material);
    }
}
