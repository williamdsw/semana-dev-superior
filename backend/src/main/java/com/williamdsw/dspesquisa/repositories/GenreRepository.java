package com.williamdsw.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williamdsw.dspesquisa.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
