package com.codeup.springblog.repositories;

import com.codeup.springblog.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
