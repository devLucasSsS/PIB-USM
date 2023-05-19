package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Repositorios.GestorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorServicio {
    @Autowired
    GestorRepositorio gestorRepositorio;

    public GestorModelo login(String rut, String password){
        return gestorRepositorio.login(rut,password);
    }

    public GestorModelo getData(String rut){
        return gestorRepositorio.findByRut(rut);
    }

    public GestorModelo getByRut(String rut) {
        return gestorRepositorio.findByRut(rut);
    }
}
