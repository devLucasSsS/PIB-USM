package com.USM.PIB.Servicios;

import com.USM.PIB.Controladores.PeticionControlador;
import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Repositorios.PeticionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<Peticion> getPeticionById(int id){
        return peticionRepositorio.findById(id);
    }
    public ArrayList<Peticion> getPeticionByBibliotecaPrestataria(int id) {
    return (ArrayList<Peticion>) peticionRepositorio.findByBibliotecaPrestataria(id);
    }
    public ArrayList<Peticion> getPeticionByBibliotecaPrestadora(int id) {
    return (ArrayList<Peticion>) peticionRepositorio.findByBibliotecaPrestadora(id);
    }
    public Peticion updateEstadoPeticion(int id, int e) {
        Peticion pet = peticionRepositorio.getById(id);
        pet.setId_estado(e);
        return peticionRepositorio.save(pet);
    }
    public Peticion updateTerminosPeticion(int idP, int id) {
        Peticion pet = peticionRepositorio.getById(idP);
        pet.setId_terminos_envio(id);
        pet.setId_estado(5);
        return peticionRepositorio.save(pet);
    }
}
