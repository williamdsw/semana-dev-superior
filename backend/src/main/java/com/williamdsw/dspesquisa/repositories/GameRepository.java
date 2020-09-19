package com.williamdsw.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williamdsw.dspesquisa.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
