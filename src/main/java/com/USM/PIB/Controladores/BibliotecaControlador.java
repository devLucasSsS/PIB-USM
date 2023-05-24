package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.BibliotecaModelo;
import com.USM.PIB.Servicios.BibliotecaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bibliotecas")
public class BibliotecaControlador {
    @Autowired
    BibliotecaServicio bibliotecaServicio;

    @GetMapping(path = "/{id}")
    public ArrayList<BibliotecaModelo> getBibliotecasByInstitucion(@PathVariable("id") int id){
        return bibliotecaServicio.getBibliotecasByInstitucion(id);
    }
    @GetMapping(path = "/{id}/bib")
    public BibliotecaModelo getBibliotecaById(@PathVariable("id") int id){
        return bibliotecaServicio.getBibliotecaById(id);
    }

    @PostMapping
    public BibliotecaModelo addBiblioteca(BibliotecaModelo bibliotecaModelo){
        return bibliotecaServicio.addBibliotecas(bibliotecaModelo);
    }
    @PostMapping(path = "/{id}")
    public void deshabilitarBiblioteca(@PathVariable("id") int id){
        bibliotecaServicio.deshabilitarBiblioteca(id);
    }
}
