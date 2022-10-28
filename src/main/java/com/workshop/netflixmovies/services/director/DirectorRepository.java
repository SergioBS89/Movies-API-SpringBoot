package com.workshop.netflixmovies.services.director;

import com.workshop.netflixmovies.model.entities.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Integer> {

    @Query(value = "SELECT * FROM director WHERE name = :name", nativeQuery = true)
    public Director findByName(String name);
}
