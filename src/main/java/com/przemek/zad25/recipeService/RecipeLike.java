package com.przemek.zad25.recipeService;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
public class RecipeLike {

    Recipe recipe;
    User user;
}
