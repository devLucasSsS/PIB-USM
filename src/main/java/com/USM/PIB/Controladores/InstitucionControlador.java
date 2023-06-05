package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Modelos.InstitucionModelo;
import com.USM.PIB.Servicios.InstitucionServicio;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/institucion")
public class InstitucionControlador {
    @Autowired
    InstitucionServicio institucionServicio;
    @GetMapping(path = "/{id}")
    public InstitucionModelo getInstitucionById(@PathVariable("id")int id){
        return institucionServicio.getInstitucionById(id);
    }
    @PostMapping
    public InstitucionModelo addInstitucion(InstitucionModelo institucion,String rut){
        return institucionServicio.addInstitucion(institucion,rut);
    }
}
