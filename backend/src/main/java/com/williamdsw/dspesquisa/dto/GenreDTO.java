package com.williamdsw.dspesquisa.dto;

import java.io.Serializable;

import com.williamdsw.dspesquisa.entities.Genre;

public class GenreDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	public GenreDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public GenreDTO(Genre genre) {
		this.id = genre.getId();
		this.name = genre.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
