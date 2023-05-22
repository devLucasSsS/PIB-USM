package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.Nivel_GestorModelo;
import com.USM.PIB.Servicios.Nivel_GestorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/ng")
public class Nivel_GestorControlador {
    @Autowired
    Nivel_GestorServicio gestorServicio;

    @GetMapping
    public ArrayList<Nivel_GestorModelo> getAll(){
        return gestorServicio.getNiveles();
    }
}
