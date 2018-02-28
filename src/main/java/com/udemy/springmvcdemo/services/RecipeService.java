package com.udemy.springmvcdemo.services;

import com.udemy.springmvcdemo.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getAllRecipes();
}
