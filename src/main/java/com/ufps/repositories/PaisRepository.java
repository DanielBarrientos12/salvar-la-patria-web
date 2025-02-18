package com.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.entities.Pais;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Integer> {

    Optional<Pais> findByNombre(String nombre);

}
