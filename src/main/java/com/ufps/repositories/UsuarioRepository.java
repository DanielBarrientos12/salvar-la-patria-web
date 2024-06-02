package com.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
