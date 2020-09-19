package com.williamdsw.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.williamdsw.dspesquisa.dto.GameDTO;
import com.williamdsw.dspesquisa.entities.Game;
import com.williamdsw.dspesquisa.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll() {
		List<Game> games = gameRepository.findAll();
		return games.stream().map(game -> new GameDTO(game)).collect(Collectors.toList());
	}


}
