package com.ufps.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MangaDTO {
	
	private Integer id;
	private String nombre;
	private LocalDate fechaLanzamiento;
	private Integer temporadas;
	private Integer anime;
	private Integer juego;
	private Integer pelicula;
	private Integer paisId;
    private Integer tipoId;
	
}
