package com.udemy.springmvcdemo.repositories;

import com.udemy.springmvcdemo.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
