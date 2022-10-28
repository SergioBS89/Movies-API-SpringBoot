package com.workshop.netflixmovies.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "title")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String date_added;
    private String release_year;
    private String rating;
    private String duration;
    private String description;
    @Max(value = 10, message = "Must be 0 to 10 value")
    @Min(value = 0, message = "Must be 0 to 10 value")
    private Float user_rating;
    @Min(value = 0, message = "It can't be negative value")
    private Integer num_ratings;

    // relation with actor
    @JoinTable(name = "title_actor", joinColumns = {
            @JoinColumn(name = "actor_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "title_id", referencedColumnName = "id")
            })
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Actor> actor = new HashSet<>();

    // relation with category
    @JoinTable(name = "title_category", joinColumns = {
            @JoinColumn(name = "category_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "title_id", referencedColumnName = "id")
            })
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Category> category = new HashSet<>();

    @JoinTable(name = "title_director", joinColumns = {
            @JoinColumn(name = "director_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "title_id", referencedColumnName = "id")
            })
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Director> director = new HashSet<>();

    public Title() {
    }

    public Title(Integer id, String name, String date_added, String rating, String duration, String description,

            Float user_rating, Integer num_ratings) {

        this.id = id;
        this.name = name;
        this.date_added = date_added;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
        this.user_rating = user_rating;
        this.num_ratings = num_ratings;
    }

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.name = Name;
    }

    /**
     * @return String return the date_added
     */
    public String getDate_added() {
        return date_added;
    }

    /**
     * @param date_added the date_added to set
     */
    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    /**
     * @return String return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return String return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Float return the user_rating
     */
    public Float getUser_rating() {
        return user_rating;
    }

    /**
     * @param user_rating the user_rating to set
     */
    public void setUser_rating(Float user_rating) {
        this.user_rating = user_rating;
    }

    /**
     * @return Integer return the num_ratings
     */
    public Integer getNum_ratings() {
        return num_ratings;
    }

    /**
     * @param num_ratings the num_ratings to set
     */
    public void setNum_ratings(Integer num_ratings) {
        this.num_ratings = num_ratings;
    }

    /**
     * @return String return the release_year
     */
    public String getRelease_year() {
        return release_year;
    }

    /**
     * @param release_year the release_year to set
     */
    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public Set<Actor> getActor() {
        return actor;
    }

    public void setActor(Set<Actor> actor) {
        this.actor = actor;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public Set<Director> getDirector() {
        return director;
    }

    public void setDirector(Set<Director> director) {
        this.director = director;
    }
}