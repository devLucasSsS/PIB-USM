package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.Nivel_GestorModelo;
import com.USM.PIB.Repositorios.Nivel_GestorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Nivel_GestorServicio {
    @Autowired
    Nivel_GestorRepositorio nivelGestorRepositorio;

    public ArrayList<Nivel_GestorModelo> getNiveles(){
        return (ArrayList<Nivel_GestorModelo>) nivelGestorRepositorio.findAll();
    }
}
