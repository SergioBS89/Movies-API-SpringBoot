package com.workshop.netflixmovies.services.actor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.netflixmovies.model.entities.Actor;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> findAll() {
        return (List<Actor>) actorRepository.findAll();
    }

    public Actor findById(Integer id) {
        Optional<Actor> proof = actorRepository.findById(id);

        if (proof.isEmpty()) {
            // throw exception here
        }

        return actorRepository.findById(id).get();
    }

    public Actor save(Actor actor) {

        return actorRepository.save(actor);
    }

    public void update(Actor actor, Integer id) {
        Actor ac = actorRepository.findById(id).get();

        ac.setName(actor.getName());
        actorRepository.save(ac);
    }

    public void delete(Integer id) {

        Optional<Actor> proof = actorRepository.findById(id);

        if (proof.isEmpty()) {
            // Throw exception here
        } else {
            actorRepository.deleteById(id);
        }
    }

    /* -------------------------------------------------------------------------- */
    /* ENDPOINT */
    /* -------------------------------------------------------------------------- */

    public Actor findActorByName(Optional<String> name) {
        return actorRepository.findActorByName(name);
    }
}