package com.USM.PIB.Servicios;

import com.USM.PIB.Controladores.EmailControlador;
import com.USM.PIB.Controladores.EstadoControlador;
import com.USM.PIB.Controladores.GestorControlador;
import com.USM.PIB.Controladores.PrestatarioControlador;
import com.USM.PIB.Modelos.*;
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
    @Autowired
    EmailControlador emailControlador;
    @Autowired
    PrestatarioControlador prestatarioControlador;
    @Autowired
    GestorControlador gestorControlador;
    @Autowired
    EstadoControlador estadoControlador;
    private static final Logger log = (Logger) LoggerFactory.getLogger(Peticion.class);

    public Peticion savePeticion(Peticion peticion){
        Peticion pet= peticionRepositorio.save(peticion);
        log.info("Nueva Peticion Creada {}",pet.toString());
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
        int estadoA = pet.getId_estado();
        pet.setId_estado(e);
        log.info("Peticion Id:{}, Actualizada | Estado Antiguo:{}, Estado Nuevo:{}",pet.getId_peticion(),estadoA,pet.getId_estado());
        Peticion p = peticionRepositorio.save(pet);
        Prestatario prestatario = prestatarioControlador.getPrestatarioByRut(pet.getRut_prestatario());
        String actualizacionPeticion = "ACTUALIZACIÓN DE PETICIÓN "+pet.getId_peticion();
        EstadoModelo estado = estadoControlador.getEstadoById(pet.getId_estado());
        String cuerpoEmail = "La petición "+pet.getId_peticion()+" ha cambiado el estado a "+estado.getEstado();
        ArrayList<GestorModelo> revisorbibPrestataria = gestorControlador.getGestorByBib(p.getId_biblioteca_prestataria());
        for (GestorModelo revisor : revisorbibPrestataria){
            DetalleEmailModelo emailPrestataria = new DetalleEmailModelo();
            emailPrestataria.setRecipient(revisor.getEmail());
            emailPrestataria.setSubject(actualizacionPeticion);
            emailPrestataria.setMsgBody(cuerpoEmail);
            emailControlador.enviarEmail(emailPrestataria);

        }
        ArrayList<GestorModelo> revisorbibPrestadora = gestorControlador.getGestorByBib(p.getId_biblioteca_prestadora());
        for (GestorModelo revisor : revisorbibPrestadora){
            DetalleEmailModelo emailPrestador = new DetalleEmailModelo();
            emailPrestador.setRecipient(revisor.getEmail());
            emailPrestador.setSubject(actualizacionPeticion);
            emailPrestador.setMsgBody(cuerpoEmail);
            emailControlador.enviarEmail(emailPrestador);
        }
        DetalleEmailModelo email = new DetalleEmailModelo();
        email.setRecipient(prestatario.getEmail());
        email.setSubject(actualizacionPeticion);
        int estadoN = p.getId_estado();
        switch (estadoN){

            case 2: // RECHAZADA VIGENCIA USUARIO
                email.setMsgBody("Le informamos por este medio que su Petición con id: "+pet.getId_peticion()+ " titulo: "+pet.getLibro()+" ha sido cancelada debido a su vigencia de usuario en su institución.");
                break;
            case 3: // RECHAZADA EXISTENCIA EN BIBLIOTECA
                email.setMsgBody("Le informamos por este medio que su Petición con id: "+pet.getId_peticion()+" titulo: "+pet.getLibro()+" ha sido cancelada debido a que hay existencias en biblioteca.");
                break;
            case 11: // MATERIAL LISTO PARA RETIRAR
                email.setMsgBody("Le informamos por este medio que su Petición con id: "+pet.getId_peticion()+" titulo: "+pet.getLibro()+" Esta lista para que la retire en su biblioteca.");
                break;
            case 13: // RECHAZADA STOCK NO DISPONIBLE
                email.setMsgBody("Le informamos por este medio que su Petición con id: "+pet.getId_peticion()+" titulo: "+pet.getLibro()+" ha sido cancelada debido a que no hay existencias disponibles para prestar.");
                break;
            case 14: // PENDIENTE STOCK NO DISPONIBLE
                email.setMsgBody("Le informamos por este medio que su Petición con id: "+pet.getId_peticion()+" titulo: "+pet.getLibro()+" esta en estado pendiente debido a que no hay existencias disponibles.");
                break;
            case 15: // CANCELADA
                email.setMsgBody("Le informamos por este medio que su Petición con id: "+pet.getId_peticion()+" titulo: "+pet.getLibro()+" ha sido cancelada.");
                break;
        }
        emailControlador.enviarEmail(email);
        return p;
    }
    public Peticion updateTerminosPeticion(int idP) {
        Peticion pet = peticionRepositorio.getById(idP);
        pet.setId_estado(5);
        return peticionRepositorio.save(pet);
    }
}
