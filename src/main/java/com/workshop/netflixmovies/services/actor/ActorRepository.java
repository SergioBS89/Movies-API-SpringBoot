package com.workshop.netflixmovies.services.actor;

import java.util.Optional;

// import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.workshop.netflixmovies.model.entities.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

    /* ------------------------ searching actors by name ------------------------ */

    @Query(value = "SELECT * FROM actor WHERE name = :name", nativeQuery = true)
    public Actor findActorByName(Optional<String> name);

}