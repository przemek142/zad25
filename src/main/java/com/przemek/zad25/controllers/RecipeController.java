package com.przemek.zad25.controllers;

import com.przemek.zad25.recipeService.Category;
import com.przemek.zad25.recipeService.Recipe;
import com.przemek.zad25.repositories.CategoryRepository;
import com.przemek.zad25.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    RecipeRepository recipeRepository;
    CategoryRepository categoryRepository;

    public RecipeController(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/wszystkiePrzepisy")
    public String wszystkiePrzepisy(Model model) {

        model.addAttribute("lista", recipeRepository.findAll());
      return "allRecipies";

    }

    @GetMapping("/idPrzepisu/{id}")
    public ResponseEntity idPrzepisu(@PathVariable("id") long id) {

        return Optional
                .ofNullable( recipeRepository.findById(id) )
                .map( user -> ResponseEntity.ok().body(user))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }


}
