package com.workshop.netflixmovies.services.title;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workshop.netflixmovies.model.entities.Title;

public interface TitleRepository extends JpaRepository<Title, Integer> {

  /* ---------------------------- searching by name --------------------------- */

  @Query(value = "SELECT * FROM title WHERE name = :name", nativeQuery = true)
  public Title findTitleByName(String name);

  /* ------------------------ searching by release_year ----------------------- */

  @Query(value = "SELECT * FROM title WHERE release_year = :releaseYear", nativeQuery = true)
  public List<Title> findTitleByReleaseYear(String releaseYear);

  /* ------------------------ searching by description ------------------------ */

  @Query(value = "SELECT * FROM title WHERE description LIKE %:description%", nativeQuery = true)
  public List<Title> findTitleByDescription(String description);

  /* ---------------------- searching titles by director ---------------------- */

  @Query(value = "SELECT * FROM title INNER JOIN title_director ON title.id = title_director.title_id WHERE title_director.director_id = :id ", nativeQuery = true)
  public List<Title> findTitleByDirector(Integer id);

  /* ---------------------- searching titles by actor ---------------------- */

  @Query(value = "SELECT * FROM title INNER JOIN title_actor on title.id = title_actor.title_id   WHERE title_actor.actor_id = :id ", nativeQuery = true)
  public List<Title> findTitleByActor(Integer id);

  /* ---------------------- searching titles by category ---------------------- */

  @Query(value = "SELECT * FROM title INNER JOIN title_category on title.id = title_category.title_id WHERE title_category.category_id = :id order by title.id", nativeQuery = true)
  public List<Title> findTitleByCategory(Integer id);

  /* --------------------------- RECOMMEND ENDPOINTS -------------------------- */

  @Query(value = "SELECT * FROM title ORDER BY user_rating DESC LIMIT :limit", nativeQuery = true)
  public List<Title> recommedBestTitles(Integer limit);

  @Query(value = "SELECT * FROM title INNER JOIN title_category on title.id = title_category.title_id WHERE title_category.category_id = :id order by user_rating desc  LIMIT :limit", nativeQuery = true)
  public List<Title> recommendBestTitlesByCategory(Integer id, Integer limit);

}
