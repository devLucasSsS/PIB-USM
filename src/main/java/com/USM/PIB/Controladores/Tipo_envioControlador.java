package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.Tipo_envioModelo;
import com.USM.PIB.Servicios.Tipo_envioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/tipo-envio")
public class Tipo_envioControlador {
    @Autowired
    Tipo_envioServicio tipoEnvioServicio;

    public Tipo_envioModelo saveTipoEnvio(@RequestBody Tipo_envioModelo tipoEnvio){
        return tipoEnvioServicio.saveTipoEnvio(tipoEnvio);
    }

    public ArrayList<Tipo_envioModelo> getTipos() {
            return tipoEnvioServicio.getTipos();
    }
    @GetMapping(path = "/{id}")
    public Tipo_envioModelo getById(@PathVariable("id")int id){
        return tipoEnvioServicio.getByIdTerm(id);
    }
}
