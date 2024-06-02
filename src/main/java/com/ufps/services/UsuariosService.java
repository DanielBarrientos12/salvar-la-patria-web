package com.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.entities.Manga;
import com.ufps.entities.Usuario;
import com.ufps.repositories.UsuarioRepository;

@Service
public class UsuariosService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Manga> getFavoriteMangas (String username){
		Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
		
		if(usuario.isEmpty()) {
			throw new RuntimeException("Objeto no encontrado");		
		} else {
			return usuario.get().getMangas();
		}
	}
	
	

}
