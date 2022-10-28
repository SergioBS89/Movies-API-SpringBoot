package com.workshop.netflixmovies.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
    }, mappedBy = "category")
    @JsonIgnore
    private Set<Title> title = new HashSet<>();

    public Category(Integer id, String name, Set<Title> title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Title> getTitle() {
        return title;
    }

    public void setTitle(Set<Title> title) {
        this.title = title;
    }
}