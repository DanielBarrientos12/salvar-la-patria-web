package com.ufps.controllers;

import com.ufps.entities.Tipo;
import com.ufps.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    TipoService tipoService;

    @GetMapping
    public List<Tipo> getTipos() {
        return tipoService.getTipos();
    }

    @GetMapping("/{id}")
    public Tipo getTipoById(@PathVariable int id) {
        return tipoService.getTipoById(id);
    }

    @GetMapping("/{nombre}")
    public Tipo getTipoByNombre(@PathVariable String nombre) {
        return tipoService.getTipoByNombre(nombre);
    }
}
