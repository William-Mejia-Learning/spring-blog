package com.codeup.springblog.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="movies")
public class Movie {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    private String moviesCategory;
    private String description;
    @Column(nullable = false)
    private String director;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;


    private String coverImage;

    public Movie() {
    }

    public Movie(String title, String moviesCategory, String description, String director, LocalDate releaseDate, String coverImage) {
        this.title = title;
        this.moviesCategory = moviesCategory;
        this.description = description;
        this.director = director;
        this.releaseDate = releaseDate;
        this.coverImage = coverImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoviesCategory() {
        return moviesCategory;
    }

    public void setMoviesCategory(String moviesCategory) {
        this.moviesCategory = moviesCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", movieCategories='" + moviesCategory + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", coverImage='" + coverImage + '\'' +
                '}';
    }
}
