package com.workshop.netflixmovies.services.title;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.workshop.netflixmovies.model.entities.Title;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public List<Title> findAll() {
        return (List<Title>) titleRepository.findAll();
    }

    /* ------------------------------- Pagination ------------------------------- */
    public Page<Title> findAllWithPages(Pageable page) {
        return titleRepository.findAll(page);
    }

    public Title findById(Integer id) {
        Optional<Title> proof = titleRepository.findById(id);

        if (proof.isEmpty()) {
            // throw exception here
        }

        return titleRepository.findById(id).get();
    }

    public Title save(Title title) {

        return titleRepository.save(title);
    }

    public void update(Title title, Integer id) {

        Title ti = titleRepository.findById(id).get();

        ti.setName(title.getName());
        ti.setDate_added(title.getDate_added());
        ti.setRating(title.getRating());
        ti.setDuration(title.getDuration());
        ti.setDescription(title.getDescription());
        ti.setUser_rating(title.getUser_rating());
        ti.setNum_ratings(title.getNum_ratings());

        titleRepository.save(ti);
    }

    public void delete(Integer id) {

        titleRepository.deleteById(id);

    }

    public Title findTitleByName(String name) {

        return (Title) titleRepository.findTitleByName(name);
    }

    public List<Title> findTitleByReleaseYear(String releaseYear) {

        return titleRepository.findTitleByReleaseYear(releaseYear);
    }

    public List<Title> findTitleByDescription(String description) {
        return titleRepository.findTitleByDescription(description);
    }

    public List<Title> findTitleByActor(Integer id) {

        return titleRepository.findTitleByActor(id);
    }

    public List<Title> findTitleByCategory(Integer id) {

        return titleRepository.findTitleByCategory(id);
    }

    public List<Title> findTitleByDirector(Integer id) {

        return titleRepository.findTitleByDirector(id);
    }

    /* --------------------------- RECOMMEND ENDPOINTS -------------------------- */

    public List<Title> recommendBestTitles(Integer limit) {

        return titleRepository.recommedBestTitles(limit);
    }

    public List<Title> recommendBestTitlesByCategory(Integer id, Integer limit) {
        return titleRepository.recommendBestTitlesByCategory(id, limit);
    }

}
