package com.workshop.netflixmovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.netflixmovies.model.entities.Title;
import com.workshop.netflixmovies.services.title.TitleService;

@RestController
public class RecommendController {

    @Autowired
    private TitleService titleService;

    @GetMapping("/recommend/best")
    public List<Title> getBestTitles(@RequestParam(value = "top") Integer limit) {

        return titleService.recommendBestTitles(limit);
    }

    @GetMapping("/recommend/category/{id}")
    public List<Title> getBestTitlesByCategory(@PathVariable Integer id,
            @RequestParam(value = "top") Integer limit) {

        return titleService.recommendBestTitlesByCategory(id, limit);
    }

}