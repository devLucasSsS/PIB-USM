package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.BibliotecaModelo;
import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Servicios.BibliotecaServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bibliotecas")
public class BibliotecaControlador {
    @Autowired
    BibliotecaServicio bibliotecaServicio;
    @Autowired
    GestorControlador gestorControlador;

    @GetMapping(path = "/{id}")
    public ArrayList<BibliotecaModelo> getBibliotecasByInstitucion(@PathVariable("id") int id){
        return bibliotecaServicio.getBibliotecasByInstitucion(id);
    }
    @GetMapping(path = "/{id}/bib")
    public BibliotecaModelo getBibliotecaById(@PathVariable("id") int id){
        return bibliotecaServicio.getBibliotecaById(id);
    }

    @PostMapping
    public BibliotecaModelo addBiblioteca(BibliotecaModelo bibliotecaModelo, String rut){
        return bibliotecaServicio.addBibliotecas(bibliotecaModelo,rut);
    }
    @PostMapping(path = "/{id}")
    public void deshabilitarBiblioteca(@PathVariable("id") int id,HttpSession session){
        GestorModelo g = gestorControlador.getDataSession(session);
        bibliotecaServicio.deshabilitarBiblioteca(id,g.getRut_gestor());
    }
}
