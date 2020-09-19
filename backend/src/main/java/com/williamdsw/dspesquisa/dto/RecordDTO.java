package com.williamdsw.dspesquisa.dto;

import java.io.Serializable;
import java.time.Instant;

import com.williamdsw.dspesquisa.entities.Record;

public class RecordDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant moment;
	private String name;
	private Integer age;
	private GameDTO gameDto;
	private GenreDTO genreDto;
	
	public RecordDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public RecordDTO(Record record) {
		this.id = record.getId();
		this.moment = record.getMoment();
		this.name = record.getName();
		this.age = record.getAge();
		this.gameDto = new GameDTO(record.getGame());
		this.genreDto = new GenreDTO(record.getGame().getGenre());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public GameDTO getGameDto() {
		return gameDto;
	}

	public void setGameDto(GameDTO gameDto) {
		this.gameDto = gameDto;
	}

	public GenreDTO getGenreDto() {
		return genreDto;
	}

	public void setGenreDto(GenreDTO genreDto) {
		this.genreDto = genreDto;
	}
}
