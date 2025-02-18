package com.ufps.services;

import com.ufps.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.entities.Pais;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> getAllCountries(){
        return paisRepository.findAll();
    }

    public Pais getPaisById(int id){
        Optional<Pais> pais = paisRepository.findById(id);
        return pais.orElse(null);
    }
    public Pais getPaisByName(String nombre){
        Optional<Pais> pais = paisRepository.findByNombre(nombre);
        return pais.orElse(null);
    }

}
