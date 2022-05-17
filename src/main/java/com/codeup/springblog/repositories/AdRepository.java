package com.codeup.springblog.repositories;

import com.codeup.springblog.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
    List<Ad> findByTitle(String title);

    @Query("FROM Ad a WHERE a.title LIKE %?1%")
    List<Ad> searchByTitleLike(String term);
}
