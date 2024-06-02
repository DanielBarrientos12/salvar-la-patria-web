package com.ufps.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufps.entities.Manga;
import com.ufps.models.MangaDTO;
import com.ufps.services.MangaService;
import com.ufps.utils.ErrorResponseUtil;

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
	public ResponseEntity<?> getMangaById(@PathVariable Integer id) {
	    try {
	        Manga manga = mangaService.findById(id);
	        return ResponseEntity.ok(manga);
	    } catch (RuntimeException e) {
	        return ErrorResponseUtil.buildErrorResponse(e);
	    }
	}

	@PostMapping
	public ResponseEntity<?> createManga(@RequestBody MangaDTO mangaDTO) {
		try {
			Manga manga = mangaService.addManga(mangaDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(manga);
		} catch (RuntimeException e) {
			return ErrorResponseUtil.buildErrorResponse(e);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateManga(@PathVariable Integer id, @RequestBody MangaDTO mangaDTO) {
		try {
			Manga updatedManga = mangaService.updateManga(id, mangaDTO);
			return ResponseEntity.ok(updatedManga);
		} catch (RuntimeException e) {
			return ErrorResponseUtil.buildErrorResponse(e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteManga(@PathVariable Integer id) {
		try {
			Manga eliminatedManga = mangaService.deleteManga(id);
			return ResponseEntity.ok(eliminatedManga);
		} catch (RuntimeException e) {
			return ErrorResponseUtil.buildErrorResponse(e);
		}
	}
}
