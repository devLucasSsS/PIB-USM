package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Repositorios.PeticionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PeticionServicio {
    @Autowired
    PeticionRepositorio peticionRepositorio;

    public Peticion savePeticion(Peticion peticion){
        return peticionRepositorio.save(peticion);
    }

    public ArrayList<Peticion> getPeticion() {
    return (ArrayList<Peticion>) peticionRepositorio.findAll();
    }
    public ArrayList<Peticion> getPeticionByBiblioteca(int id) {
    return (ArrayList<Peticion>) peticionRepositorio.findByBiblioteca(id);
    }



}
