package com.workshop.netflixmovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import com.workshop.netflixmovies.model.entities.Title;
import com.workshop.netflixmovies.services.title.TitleService;

@RestController
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping("/pages")
    public Page<Title> findAllWithPages(@PageableDefault(size = 10, page = 0) Pageable page) {

        return titleService.findAllWithPages(page);
    }

    @GetMapping("/")
    public List<Title> findAll() {
        return titleService.findAll();
    }

    @GetMapping("/{id}")
    public Title findById(@PathVariable Integer id) {
        return titleService.findById(id);
    }

    @PostMapping("/")
    public Title save(@RequestBody Title title) {
        return titleService.save(title);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Title title, @PathVariable Integer id) {

        titleService.update(title, id);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        titleService.delete(id);
    }

    @GetMapping("/name")
    public Title getByName(@RequestParam(value = "name") String name) {

        return titleService.findTitleByName(name);
    }

    @GetMapping("/releaseyear")
    public List<Title> getByYear(@RequestParam(value = "year") String year) {
        return titleService.findTitleByReleaseYear(year);
    }

    @GetMapping("/description")
    public List<Title> getByDescription(@RequestParam(value = "description") String description) {
        return titleService.findTitleByDescription(description);
    }

    @GetMapping("/{id}/actor")
    public List<Title> getByActor(@PathVariable Integer id) {
        return titleService.findTitleByActor(id);
    }

    @GetMapping("/{id}/director")
    public List<Title> getByDirector(@PathVariable Integer id) {
        return titleService.findTitleByDirector(id);
    }

    @GetMapping("/{id}/category")
    public List<Title> getByCategory(@PathVariable Integer id) {
        return titleService.findTitleByCategory(id);

    }
}