package com.ufps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.entities.Manga;
import com.ufps.entities.Usuario;
import com.ufps.repositories.UsuarioRepository;


@Service
public class UsuariosService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	MangaService mangaService;

	public List<Manga> getFavoriteMangas(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Objeto no encontrado"));
		return usuario.getMangas();
	}

	public List<Manga> deleteFavoriteManga(String username, Integer mangaId) {
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		Manga mangaToRemove = usuario.getMangas().stream().filter(manga -> manga.getId().equals(mangaId)).findFirst()
				.orElseThrow(() -> new RuntimeException("Favorito no encontrado"));

		usuario.getMangas().remove(mangaToRemove);

        // Asegurarse de que el manga también elimine el usuario de su lista de usuarios
        mangaToRemove.getUsuarios().remove(usuario);

        usuarioRepository.save(usuario);

		return getFavoriteMangas(username);
	}

	public List<Manga> addFavoriteManga(String username, Integer mangaId) {
		Manga manga = mangaService.findById(mangaId);

		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Objeto no encontrado"));

		if (usuario.getMangas().contains(manga)) {
			throw new RuntimeException("Favorito ya se encuentra registrado");
		}

		usuario.getMangas().add(manga);

		// Asegurarse de que el manga también tenga el usuario agregado a su lista de usuarios
        manga.getUsuarios().add(usuario);

        usuarioRepository.save(usuario);

		return getFavoriteMangas(username);
	}

}