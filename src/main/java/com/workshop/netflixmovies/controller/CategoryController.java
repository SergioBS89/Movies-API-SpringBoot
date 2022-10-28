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

import com.workshop.netflixmovies.model.entities.Category;
import com.workshop.netflixmovies.services.category.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public Category save(@RequestBody Category category) {

        return categoryService.save(category);
    }

    @PutMapping("/")
    public void update(@RequestBody Category category, @PathVariable Integer id) {
        categoryService.update(category, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        categoryService.delete(id);
    }

    /* -------------------------------- Endpoint -------------------------------- */

    @GetMapping("/search/name")
    public Category findCategoryByName(@RequestParam(value = "name") Optional<String> name) {

        return categoryService.findCategoryByName(name);
    }
}