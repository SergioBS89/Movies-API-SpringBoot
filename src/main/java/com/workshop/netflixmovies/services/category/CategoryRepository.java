package com.workshop.netflixmovies.services.category;

import java.util.Optional;

// import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.workshop.netflixmovies.model.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    /* ---------------------- searching categories by name --------------------- */

    @Query(value = "SELECT * FROM category WHERE name like :name", nativeQuery = true)
    public Category findCategoryByName(Optional<String> name);

}