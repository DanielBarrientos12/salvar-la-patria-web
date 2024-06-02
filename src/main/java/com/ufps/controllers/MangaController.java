package com.ufps.controllers;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufps.entities.Manga;
import com.ufps.models.MangaDTO;
import com.ufps.services.MangaService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/mangas")
public class MangaController {

	@Autowired
	private MangaService mangaService;

	@GetMapping("/status")
	public Map<String, Object> getStatus() {
		Map<String, Object> status = new HashMap<>();
		status.put("message", "Servidor en funcionamiento");
		status.put("timestamp", LocalDateTime.now());
		return status;
	}

	@GetMapping
	public List<Manga> getAllMangas() {
		return mangaService.getAllMangas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Manga> getMangaById(@PathVariable Integer id) {
		Optional<Manga> manga = mangaService.findById(id);
		if (manga.isPresent()) {
			return ResponseEntity.ok(manga.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<Manga> createManga(@RequestBody MangaDTO mangaDTO) {
		Manga manga = mangaService.addManga(mangaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(manga);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateManga(@PathVariable Integer id, @RequestBody MangaDTO mangaDTO) {
		try {
			Manga updatedManga = mangaService.updateManga(id, mangaDTO);
			if (updatedManga != null) {
				return ResponseEntity.ok(updatedManga);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
			}
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteManga(@PathVariable Integer id) {
		try {
			Manga eliminatedManga = mangaService.deleteManga(id);
			return ResponseEntity.ok(eliminatedManga);
		} catch (RuntimeException e) {
			if (e.getMessage().equals("Objeto no encontrado")) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(Collections.singletonMap("msg", "Manga not found"));
			} else if (e.getMessage().equals("Manga tiene usuarios asociados")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(Collections.singletonMap("msg", "Manga tiene usuarios asociados"));
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(Collections.singletonMap("msg", e.getMessage()));
			}

		}
	}

}
