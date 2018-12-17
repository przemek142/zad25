package com.przemek.zad25.repositories;

import com.przemek.zad25.recipeService.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
