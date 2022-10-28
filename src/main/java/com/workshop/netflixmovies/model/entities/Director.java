package com.workshop.netflixmovies.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
    }, mappedBy = "director")
    @JsonIgnore
    private Set<Title> title = new HashSet<>();

    public Director() {
    }

    public Director(Integer id, String name, Set<Title> title) {
        this.id = id;
        this.name = name;
        this.title = title;
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
