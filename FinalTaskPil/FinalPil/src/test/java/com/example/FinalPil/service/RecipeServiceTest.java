package com.example.FinalPil.service;

import com.example.FinalPil.controller.RecipeController;
import com.example.FinalPil.model.Recipe;
import com.example.FinalPil.model.Zone;
import com.example.FinalPil.repository.RecipeRepository;
import com.example.FinalPil.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
public class RecipeServiceTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    RecipeService service;

    @Test
    void aNewRecipeShouldBeCreated() throws Exception {
        Recipe recipe = Recipe.builder()
                .recipeName("Pot for aquatic plants")
                .build();

        when(service.saveRecipe(recipe)).thenReturn(recipe);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/recipes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(recipe));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.recipeName", is("Pot for aquatic plants")));
    }

    @Test
    void weShouldGetAllRecipes() throws Exception {
        Recipe recipe1 = Recipe.builder()
                .id(1L)
                .recipeName("Key Ring")
                .material("Plastic")
                .steps("Preheat the oven to 150 degrees and cover the tray with foil.")
                .build();

        Recipe recipe2 = Recipe.builder()
                .id(2L)
                .recipeName("Glass Vase")
                .material("Glass")
                .steps("The first thing to do is to take the glass bottle and remove any paper or glue residue.")
                .build();

        List<Recipe> records = new ArrayList<>(Arrays.asList(recipe1, recipe2));

        Mockito.when(service.getRecipes()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/recipes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].recipeName", is("Glass Vase")));
    }

    @Test
    public void weShouldGetARecipeById() throws Exception {
        Recipe recipe1 = Recipe.builder()
                .id(1L)
                .recipeName("Key Ring")
                .material("Plastic")
                .steps("Preheat the oven to 150 degrees and cover the tray with foil.")
                .build();


        Mockito.when(service.getRecipeById(recipe1.getId())).thenReturn(recipe1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/recipes/" + recipe1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.recipeName", is("Key Ring")));
    }

    @Test
    void aRecipeShouldBeDeleted()throws Exception{
        Recipe recipe1 = Recipe.builder()
                .id(1L)
                .recipeName("Key Ring")
                .material("Plastic")
                .steps("Preheat the oven to 150 degrees and cover the tray with foil.")
                .build();

        Mockito.when(service.getRecipeById(recipe1.getId())).thenReturn(recipe1);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/recipes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void weShouldGetARecipeByMaterial() throws Exception {
        Recipe recipe = Recipe.builder()
                .id(4L)
                .recipeName("Key Ring")
                .material("Plastic")
                .steps("Preheat the oven to 150 degrees and cover the tray with foil.")
                .build();

        Mockito.when(service.findByMaterial(recipe.getMaterial())).thenReturn(recipe);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/recipes/material/" + recipe.getMaterial())
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.recipeName", is("Key Ring")));
    }
}
