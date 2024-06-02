package com.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.entities.Manga;
import com.ufps.entities.Pais;
import com.ufps.entities.Tipo;
import com.ufps.models.MangaDTO;
import com.ufps.repositories.MangaRepository;
import com.ufps.repositories.PaisRepository;
import com.ufps.repositories.TipoRepository;

@Service
public class MangaService {

	@Autowired
	private MangaRepository mangaRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private TipoRepository tipoRepository;

	public List<Manga> getAllMangas() {
		return mangaRepository.findAll();
	}

	public Manga findById(Integer id) {
		Optional<Manga> manga = mangaRepository.findById(id);
		if (manga.isPresent()) {
			return manga.get();
		} else {
			throw new RuntimeException("Objeto no encontrado");
		}
	}

	public Manga addManga(MangaDTO mangaDTO) {
		Manga manga = new Manga();
		manga.setNombre(mangaDTO.getNombre());
		manga.setFechaLanzamiento(mangaDTO.getFechaLanzamiento());
		manga.setTemporadas(mangaDTO.getTemporadas());
		manga.setAnime(mangaDTO.getAnime());
		manga.setJuego(mangaDTO.getJuego());
		manga.setPelicula(mangaDTO.getPelicula());

		Pais pais = paisRepository.findById(mangaDTO.getPaisId())
				.orElseThrow(() -> new RuntimeException("Pais no existe"));
		manga.setPais(pais);

		Tipo tipo = tipoRepository.findById(mangaDTO.getTipoId())
				.orElseThrow(() -> new RuntimeException("Tipo no existe"));
		manga.setTipo(tipo);

		return mangaRepository.save(manga);
	}

	public Manga updateManga(Integer id, MangaDTO mangaDTO) {
		Manga mangaReturn = findById(id);

		mangaReturn.setNombre(mangaDTO.getNombre());
		mangaReturn.setFechaLanzamiento(mangaDTO.getFechaLanzamiento());
		mangaReturn.setTemporadas(mangaDTO.getTemporadas());
		mangaReturn.setAnime(mangaDTO.getAnime());
		mangaReturn.setJuego(mangaDTO.getJuego());
		mangaReturn.setPelicula(mangaDTO.getPelicula());

		Pais pais = paisRepository.findById(mangaDTO.getPaisId())
				.orElseThrow(() -> new RuntimeException("Pais no existe"));
		mangaReturn.setPais(pais);

		Tipo tipo = tipoRepository.findById(mangaDTO.getTipoId())
				.orElseThrow(() -> new RuntimeException("Tipo no existe"));
		mangaReturn.setTipo(tipo);

		return mangaRepository.save(mangaReturn);
	}

	public Manga deleteManga(Integer id) {
		Optional<Manga> manga = mangaRepository.findById(id);

		if (manga.isEmpty()) {
			throw new RuntimeException("Objeto no encontrado");
		} else if (!manga.get().getUsuarios().isEmpty()) {
			throw new RuntimeException("Manga tiene usuarios asociados");
		}

		mangaRepository.deleteById(id);
		return manga.get();
	}
}