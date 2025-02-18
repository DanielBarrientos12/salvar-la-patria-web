package com.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.entities.Tipo;

import java.util.Optional;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {

    Optional<Tipo> findByNombre(String nombre);

}
