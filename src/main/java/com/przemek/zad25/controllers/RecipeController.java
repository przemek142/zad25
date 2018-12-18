package com.przemek.zad25.controllers;

import com.przemek.zad25.recipeService.Category;
import com.przemek.zad25.recipeService.Recipe;
import com.przemek.zad25.repositories.CategoryRepository;
import com.przemek.zad25.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    @GetMapping("/")
    public String hello() {
        return "redirect:/wszystkiePrzepisy";
    }

    @GetMapping("/wszystkiePrzepisy")
    public String wszystkiePrzepisy(
            @RequestParam(value = "cat", required = false, defaultValue = "0") long cat,
            @RequestParam(value = "likes", required = false, defaultValue = "0") long likes,
            Model model) {
        System.out.println(cat);
        model.addAttribute("listaKategorii", categoryRepository.findAll());

        if (cat == 0) {
            Category category = new Category();
            category.setDescription("");
            category.setPhotoURL("http://s3.party.pl/newsy/ksiazka-kucharska-294176-quiz.jpg");
            category.setName("Wszystkie przepisy");
            model.addAttribute("cat", category);
            model.addAttribute("lista", recipeRepository.findRecipesByLikesGreaterThan(likes));
        } else {
            model.addAttribute("lista",
                    recipeRepository.findRecipesByCategoriesAndLikesGreaterThan(categoryRepository.findById(cat).get(),likes));
            model.addAttribute("cat", categoryRepository.findById(cat).get());
        }
        return "allRecipies";

    }

    @GetMapping("/idPrzepisu/{id}")
    public String idPrzepisu(@PathVariable("id") long id, Model model) {
        Recipe recipe = recipeRepository.findById(id).get();
        model.addAttribute("przepis", recipe);

        Category category = new Category();
        category.setDescription("");
        category.setPhotoURL("http://s3.party.pl/newsy/ksiazka-kucharska-294176-quiz.jpg");
        category.setName("Przepis");
        model.addAttribute("cat", category);

        String categories = "Kategorie: ";
        for (int i = 0; i < recipe.getCategories().size(); i++) {
            categories += recipe.getCategories().get(i).getName();
            if (i != recipe.getCategories().size() - 1)
                categories += ", ";
        }
        model.addAttribute("kategorie", categories);
        return "recipe";
    }

    @PostMapping("/usunPrzepis/{id}")
    @Transactional
    public String usunPrzepis(@PathVariable("id") long id) {
        recipeRepository.deleteById(id);
        return "redirect:/wszystkiePrzepisy";

    }

    @PostMapping("/likePrzepis/{id}")
    @Transactional
    public String likePrzepis(@PathVariable("id") long id) {
        Recipe recipe = recipeRepository.findById(id).get();
        recipe.setLikes(recipe.getLikes() + 1);
        recipeRepository.save(recipe);
        return "redirect:/idPrzepisu/" + recipe.getId();

    }

    @GetMapping("/edytujPrzepis")
    @Transactional
    public String edytujPrzepis(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") long id) {
        Category category = new Category();
        category.setDescription("");
        category.setPhotoURL("http://s3.party.pl/newsy/ksiazka-kucharska-294176-quiz.jpg");
        category.setName("Dodaj przepis");
        model.addAttribute("cat", category);

        model.addAttribute("listaKategorii", categoryRepository.findAll());

        Recipe recipe;
        if (id == 0) {
            recipe = new Recipe();
        } else {
            recipe = recipeRepository.findById(id).get();
        }
        model.addAttribute("recipe", recipe);
        return "dodaj";

    }

    @PostMapping("/edytujPrzepis")
    public String edytujPrzepisZapis(Model model, Recipe recipe) {

        recipeRepository.save(recipe);

        return "redirect:/wszystkiePrzepisy";
    }


}
