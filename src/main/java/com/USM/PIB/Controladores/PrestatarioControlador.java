package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.Prestatario;
import com.USM.PIB.Servicios.PrestatarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("prestatario")
public class PrestatarioControlador {
    @Autowired
    PrestatarioServicio prestatarioServicio;

    @GetMapping(path = "/{rut}")
    public String getEmailByRut(@PathVariable("rut")String rut){
        return prestatarioServicio.getEmailByRut(rut);
    }
    @PostMapping("prestatario/nuevo")
    public Prestatario savePrestatario(@RequestBody Prestatario prestatario){
        return new ResponseEntity<>(this.prestatarioServicio.savePrestatario(prestatario), HttpStatus.CREATED).getBody();
    }

}
