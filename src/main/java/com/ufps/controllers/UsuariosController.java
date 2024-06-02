package com.ufps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.services.UsuariosService;
import com.ufps.utils.ErrorResponseUtil;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @GetMapping("/{username}/favoritos")
    public ResponseEntity<?> getFavoriteMangasUser(@PathVariable String username) {
        try {
            return ResponseEntity.ok(usuariosService.getFavoriteMangas(username));
        } catch (Exception e) {
            return ErrorResponseUtil.buildErrorResponse(e);
        }
    }

    @DeleteMapping("/{username}/favoritos/{mangaId}")
    public ResponseEntity<?> deleteFavoriteMangaUser(@PathVariable String username, @PathVariable Integer mangaId) {
        try {
            return ResponseEntity.ok(usuariosService.deleteFavoriteManga(username, mangaId));
        } catch (Exception e) {
            return ErrorResponseUtil.buildErrorResponse(e);
        }
    }
    
    @PostMapping("/{username}/favoritos/{mangaId}")
    public ResponseEntity<?> addFavoriteMangaUser(@PathVariable String username, @PathVariable Integer mangaId){
    	try {
            return ResponseEntity.ok(usuariosService.addFavoriteManga(username, mangaId));
        } catch (Exception e) {
            return ErrorResponseUtil.buildErrorResponse(e);
        }
    }
}
