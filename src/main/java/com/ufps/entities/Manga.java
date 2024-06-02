package com.ufps.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Manga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
    private LocalDate fechaLanzamiento;
    private Integer temporadas;
    private Integer anime;
    private Integer juego;
    private Integer pelicula;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private Tipo tipo;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "favorito",
			joinColumns = @JoinColumn(name = "manga_id"),
			inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	public List<Usuario> usuarios;

}
