package com.ufps.services;

import com.ufps.entities.Tipo;
import com.ufps.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {

    @Autowired
    TipoRepository tipoRepository;

    public List<Tipo> getTipos(){
        return tipoRepository.findAll();
    }

    public Tipo getTipoById(int id){
        Optional<Tipo> tipo = tipoRepository.findById(id);
        return tipo.orElse(null);
    }

    public Tipo getTipoByNombre(String nombre){
        Optional<Tipo> tipo = tipoRepository.findByNombre(nombre);
        return tipo.orElse(null);
    }
}
