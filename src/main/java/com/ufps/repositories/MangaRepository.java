package com.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.entities.Manga;

public interface MangaRepository extends JpaRepository<Manga, Integer> {

}
