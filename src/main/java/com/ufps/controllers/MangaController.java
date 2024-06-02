package com.ufps.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Manga> getAllMangas (){
		return mangaService.getAllMangas();
	}
	
	@GetMapping("/{id}")
	public Optional<Manga> getMangaById(@PathVariable Integer id) {
	    Optional<Manga> manga = mangaService.findById(id);
		return manga;
	}

	@PostMapping
	public Manga createManga(@RequestBody MangaDTO mangaDTO) {
        return mangaService.addManga(mangaDTO);
    }
	
	@PutMapping("/{id}")
	public String updateManga(@PathVariable String id, @RequestBody String entity) {
		//TODO: process PUT request
		
		return entity;
	}

}
