package com.przemek.zad25.recipeService;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property ="id")
@Entity
@ToString(exclude = "categories")
public @Data
class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String photoURL;
    private Long likes;

    @ManyToMany(cascade=CascadeType.PERSIST)

    private List<Category> categories;

//    @ManyToMany
//    RecipeLike recipeLike;



    public Recipe() {
    }
}
