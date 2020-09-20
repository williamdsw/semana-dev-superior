package com.williamdsw.dspesquisa.resources;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping
	public ResponseEntity<Page<RecordDTO>> findByMoments
	(
		@RequestParam(value = "min", defaultValue = "") String min,
		@RequestParam(value = "max", defaultValue = "") String max,
		@RequestParam(value = "page", defaultValue = "0") Integer page,
		@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
		@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
		@RequestParam(value = "direction", defaultValue = "DESC") String direction
	) {
		Instant minDate = (min != null && !min.isEmpty() ? Instant.parse(min) : null);
		Instant maxDate = (max != null && !max.isEmpty() ? Instant.parse(max) : null);
		linesPerPage = (linesPerPage == 0 ? Integer.MAX_VALUE : linesPerPage);
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		
		Page<RecordDTO> pageDto = recordService.findByMoments(minDate, maxDate, pageRequest);
		return ResponseEntity.ok().body(pageDto);
	}
}
