package com.przemek.zad25.recipeService;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property ="id")
@Entity
public @Data
class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String photoURL;

    @ManyToMany(mappedBy = "recipes")
    private List<Category> categories;

//    @ManyToMany
//    RecipeLike recipeLike;


    public Recipe() {
    }
}
