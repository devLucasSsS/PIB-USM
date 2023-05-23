package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.BibliotecaModelo;
import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Repositorios.GestorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    public GestorModelo addGestor(GestorModelo gestor) {
        return gestorRepositorio.save(gestor);
    }

    public ArrayList<GestorModelo> getByBib(int id) {
        return gestorRepositorio.getByBib(id);
    }

    public void deshabilitarRevisor(String rut) {
            GestorModelo g = getByRut(rut);
            g.setHabilitado(0);
            gestorRepositorio.save(g);
    }
}
