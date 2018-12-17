package com.przemek.zad25.repositories;

import com.przemek.zad25.recipeService.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
