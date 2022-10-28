package com.workshop.netflixmovies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.netflixmovies.model.entities.Actor;
import com.workshop.netflixmovies.services.actor.ActorService;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/")
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable Integer id) {
        return actorService.findById(id);
    }

    @PostMapping("/")
    public Actor save(@RequestBody Actor actor) {

        return actorService.save(actor);
    }

    @PutMapping("/")
    public void update(@RequestBody Actor actor, @PathVariable Integer id) {

        actorService.update(actor, id);
    }

    @DeleteMapping("/")
    public void delete(@PathVariable Integer id) {
        actorService.delete(id);
    }

    /* -------------------------- Endpoint find by name ------------------------- */

    @GetMapping("/search/name")
    public Actor findByActor(@RequestParam(value = "name") Optional<String> name) {

        return actorService.findActorByName(name);
    }


}