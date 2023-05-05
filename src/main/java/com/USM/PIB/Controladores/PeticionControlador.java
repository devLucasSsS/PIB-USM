package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.BibliotecaModelo;
import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Servicios.PeticionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/peticion")
public class PeticionControlador {

    @Autowired
    PeticionServicio peticionServicio;
    @PostMapping
    public Peticion savePeticion(@RequestBody Peticion peticion){
        return new ResponseEntity<>(this.peticionServicio.savePeticion(peticion), HttpStatus.CREATED).getBody();
    }

    public ArrayList<Peticion> getPeticiones() {
        return this.peticionServicio.getPeticion();
    }
    @GetMapping(path = "/{id}")
    public ArrayList<Peticion> getPeticionByBibliotecas(@PathVariable("id") int id){
        return peticionServicio.getPeticionByBiblioteca(id);
    }
}
