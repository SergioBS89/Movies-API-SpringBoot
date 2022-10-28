package com.workshop.netflixmovies.services.director;

import com.workshop.netflixmovies.model.entities.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> findAll() {
        return (List<Director>) directorRepository.findAll();
    }

    public Director findById(Integer id) {
        Optional<Director> proof = directorRepository.findById(id);

        if (proof.isEmpty()) {
            // throw exception here
        }

        return directorRepository.findById(id).get();
    }

    public Director findByName(String name) {
        return directorRepository.findByName(name);
    }

    public Director save(Director director) {

        return directorRepository.save(director);
    }

    public void update(Director director, Integer id) {

        Director di = directorRepository.findById(id).get();

        di.setName(director.getName());
        di.setTitle(director.getTitle());

        directorRepository.save(di);

    }

    public void delete(Integer id) {

        Optional<Director> proof = directorRepository.findById(id);

        if (proof.isEmpty()) {
            // Throw exception here
        } else {
            directorRepository.deleteById(id);
        }
    }
}
