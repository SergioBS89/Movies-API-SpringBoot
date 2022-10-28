package com.workshop.netflixmovies.services.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.netflixmovies.model.entities.Category;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category findById(Integer id) {
        Optional<Category> proof = categoryRepository.findById(id);

        if (proof.isEmpty()) {
            // throw exception here
        }

        return categoryRepository.findById(id).get();
    }

    public Category save(Category category) {

        return categoryRepository.save(category);
    }

    public void update(Category category, Integer id) {

        Category cat = categoryRepository.findById(id).get();

        cat.setName(category.getName());

        categoryRepository.save(cat);
    }

    public void delete(Integer id) {
        Optional<Category> proof = categoryRepository.findById(id);

        if (proof.isEmpty()) {
            // Throw exception here
        } else {
            categoryRepository.deleteById(id);
        }
    }
    /* -------------------------------------------------------------------------- */
    /* ENDPOINTS */
    /* -------------------------------------------------------------------------- */

    public Category findCategoryByName(Optional<String> name) {
        return categoryRepository.findCategoryByName(name);
    }
}