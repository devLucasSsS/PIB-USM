package com.USM.PIB.Servicios;

import com.USM.PIB.Controladores.PeticionControlador;
import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Repositorios.PeticionRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PeticionServicio {
    @Autowired
    PeticionRepositorio peticionRepositorio;
    private static final Logger log = (Logger) LoggerFactory.getLogger(Peticion.class);

    public Peticion savePeticion(Peticion peticion){
        Peticion pet= peticionRepositorio.save(peticion);
        log.info("Nueva Peticion Creada Id:{} ,Libro:{}, Autor:{}, IdBibPrestataria: {}, IdInstPrestataria:{}, IdBibPrestadora:{}, IdInstPrestadora, Rut:{}",
                pet.getId_peticion(),pet.getLibro(),pet.getAutor(),pet.getId_biblioteca_prestataria(),pet.getId_institucion_prestataria(),
                pet.getId_biblioteca_prestadora(), pet.getId_institucion_prestadora(),pet.getRut_prestatario());
        return pet;
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
    public Peticion updateTerminosPeticion(int idP) {
        Peticion pet = peticionRepositorio.getById(idP);
        pet.setId_estado(5);
        return peticionRepositorio.save(pet);
    }
}
