package com.udemy.springmvcdemo.services;

import com.udemy.springmvcdemo.commands.RecipeCommand;
import com.udemy.springmvcdemo.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getAllRecipes();

    Recipe findById(long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
