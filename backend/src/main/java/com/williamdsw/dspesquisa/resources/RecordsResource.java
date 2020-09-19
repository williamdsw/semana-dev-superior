package com.williamdsw.dspesquisa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williamdsw.dspesquisa.dto.RecordDTO;
import com.williamdsw.dspesquisa.dto.RecordInsertDTO;
import com.williamdsw.dspesquisa.services.RecordService;

@RestController
@RequestMapping (value = "/records")
public class RecordsResource {
	
	@Autowired
	private RecordService recordService;
	
	@PostMapping
	public ResponseEntity<RecordDTO> insert (@RequestBody RecordInsertDTO insertDTO) {
		RecordDTO dto = recordService.insert(insertDTO);
		return ResponseEntity.ok().body(dto);
	}
}
