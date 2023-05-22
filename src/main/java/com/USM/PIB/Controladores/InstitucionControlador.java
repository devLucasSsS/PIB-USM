package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.InstitucionModelo;
import com.USM.PIB.Servicios.InstitucionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public InstitucionModelo addInstitucion(InstitucionModelo institucion){
        return institucionServicio.addInstitucion(institucion);
    }
}
