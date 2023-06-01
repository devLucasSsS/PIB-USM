package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.Prestatario;
import com.USM.PIB.Servicios.PrestatarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestatario")
public class PrestatarioControlador {
    @Autowired
    PrestatarioServicio prestatarioServicio;

    @GetMapping(path = "/{rut}")
    public String getEmailByRut(@PathVariable("rut")String rut){
        return prestatarioServicio.getEmailByRut(rut);
    }
    @GetMapping(path = "/{rut}/1")
        public Prestatario getPrestatarioByRut(@PathVariable("rut")String rut){
            return prestatarioServicio.getByRut(rut);
        }

}
