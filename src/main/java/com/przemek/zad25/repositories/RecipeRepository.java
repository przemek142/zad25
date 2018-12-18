package com.przemek.zad25.repositories;

import com.przemek.zad25.recipeService.Category;
import com.przemek.zad25.recipeService.Recipe;
import com.przemek.zad25.recipeService.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findRecipesByCategories(Category cat);

    List<Recipe> findRecipesByCategoriesAndLikesGreaterThan(Category cat, Long likes);
    List<Recipe> findRecipesByLikesGreaterThan(Long likes);

}
