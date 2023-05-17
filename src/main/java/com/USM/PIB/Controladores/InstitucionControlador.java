package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.InstitucionModelo;
import com.USM.PIB.Servicios.InstitucionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institucion")
public class InstitucionControlador {
    @Autowired
    InstitucionServicio institucionServicio;

    @GetMapping(path = "/{id}")
    public InstitucionModelo getInstitucionById(@PathVariable("id")int id){
        return institucionServicio.getInstitucionById(id);
    }
}
