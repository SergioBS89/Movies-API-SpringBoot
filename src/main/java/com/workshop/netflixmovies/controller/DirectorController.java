package com.workshop.netflixmovies.controller;

import com.workshop.netflixmovies.model.entities.Director;
import com.workshop.netflixmovies.services.director.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/")
    public List<Director> findAll() {
        return directorService.findAll();
    }

    @GetMapping("/{id}")
    public Director findById(@PathVariable Integer id) {
        return directorService.findById(id);
    }

    @GetMapping("/name")
    public Director findByName(@PathVariable String name) {

        return directorService.findByName(name);
    }

    @PostMapping("/")
    public Director save(@RequestBody Director director) {

        return directorService.save(director);
    }

    @PutMapping("/")
    public void update(@RequestBody Director director, @PathVariable Integer id) {
        directorService.update(director, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        directorService.delete(id);
    }
}
