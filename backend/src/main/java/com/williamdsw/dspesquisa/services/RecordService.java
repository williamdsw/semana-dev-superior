package com.williamdsw.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.williamdsw.dspesquisa.dto.RecordDTO;
import com.williamdsw.dspesquisa.dto.RecordInsertDTO;
import com.williamdsw.dspesquisa.entities.Game;
import com.williamdsw.dspesquisa.entities.Record;
import com.williamdsw.dspesquisa.repositories.GameRepository;
import com.williamdsw.dspesquisa.repositories.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert (RecordInsertDTO insertDTO) {
		Record record = new Record();
		record.setName(insertDTO.getName());
		record.setAge(insertDTO.getAge());
		record.setMoment(Instant.now());
		
		Game game = gameRepository.getOne(insertDTO.getGameId());
		record.setGame(game);
		
		record = recordRepository.save(record);
		
		return new RecordDTO(record);
	}
	
	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		
		Page<Record> pageRecord = recordRepository.findByMoments(minDate, maxDate, pageRequest);
		return pageRecord.map(record -> new RecordDTO(record));
	}

}
