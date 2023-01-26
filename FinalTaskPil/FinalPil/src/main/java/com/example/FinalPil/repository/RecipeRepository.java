package com.example.FinalPil.repository;

import com.example.FinalPil.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findByMaterial(String material);
}
