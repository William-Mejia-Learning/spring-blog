package com.codeup.springblog.repositories;

import com.codeup.springblog.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleIsLikeIgnoreCase(String title);

    List<Movie> findByTitleContainsIgnoreCaseAndDescriptionContainsIgnoreCase(String title, String description);

    List<Movie> findByIdEquals(long id);

}
