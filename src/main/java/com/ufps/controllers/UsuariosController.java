package com.ufps.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	UsuariosService usuariosService;
	
	@GetMapping("/{username}/favoritos")
	public ResponseEntity<?> getFavoriteMangas(@PathVariable String username){
		try {
			return ResponseEntity.ok(usuariosService.getFavoriteMangas(username));
		} catch (Exception e) {
			if (e.getMessage().equals("Objeto no encontrado")) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(Collections.singletonMap("msg", "Objeto no encontrado"));
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(Collections.singletonMap("msg", e.getMessage()));
			}
			
		}
	}

}
