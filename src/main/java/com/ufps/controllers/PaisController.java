package com.ufps.controllers;

import com.ufps.entities.Pais;
import com.ufps.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> getAllCountries(){
        return paisService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Pais getPaisById(@PathVariable int id){
        return paisService.getPaisById(id);
    }

    @GetMapping("/{nombre}")
    public Pais getPaisByNombre(@PathVariable String nombre){
        return paisService.getPaisByName(nombre);
    }

}
