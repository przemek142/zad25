package com.przemek.zad25.recipeService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;
    String password;
    String nick;

//    @OneToMany
//    List<RecipeLike> recipeLikes;

    public User() {
    }
}
