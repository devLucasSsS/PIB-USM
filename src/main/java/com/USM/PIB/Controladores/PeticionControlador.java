package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Servicios.PeticionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/peticion")
public class PeticionControlador {

    @Autowired
    PeticionServicio peticionServicio;
    @Autowired
    Tipo_envioControlador tipoEnvioControlador;
    @Autowired
    Terminos_EnvioControlador terminosEnvioControlador;
    @PostMapping
    public Peticion savePeticion(@RequestBody Peticion peticion){
        return new ResponseEntity<>(this.peticionServicio.savePeticion(peticion), HttpStatus.CREATED).getBody();
    }

    public ArrayList<Peticion> getPeticiones() {
        return this.peticionServicio.getPeticion();
    }

    public Optional<Peticion> getPeticionById(@PathVariable("id") int id){
        return peticionServicio.getPeticionById(id);
    }
    @GetMapping(path = "/prestataria/{id}")
    public ArrayList<Peticion> getPeticionByBibliotecasPrestataria(@PathVariable("id") int id){
        return peticionServicio.getPeticionByBibliotecaPrestataria(id);
    }
    @GetMapping(path = "/prestadora/{id}")
    public ArrayList<Peticion> getPeticionByBibliotecasPrestadora(@PathVariable("id") int id){
        return peticionServicio.getPeticionByBibliotecaPrestadora(id);
    }
    @PutMapping(path = "/{id}/{e}")
    public Peticion updateEstadoPeticion(@PathVariable("id")int id, @PathVariable("e")int e){
        return peticionServicio.updateEstadoPeticion(id,e);
    }



}
