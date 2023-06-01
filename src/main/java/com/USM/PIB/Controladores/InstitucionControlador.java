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
@Slf4j
@RequestMapping("/institucion")
public class InstitucionControlador {
    @Autowired
    InstitucionServicio institucionServicio;
    private InstitucionModelo inst;
    private static final Logger log = (Logger) LoggerFactory.getLogger(GestorModelo.class);
    @GetMapping(path = "/{id}")
    public InstitucionModelo getInstitucionById(@PathVariable("id")int id){

        inst = institucionServicio.getInstitucionById(id);
        if (inst!=null){
            return inst;
        }else {
            String mensaje = "Institucion con ID "+id+" no se encuentra";
            log.error(mensaje);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,mensaje);
        }
    }
    @PostMapping
    public InstitucionModelo addInstitucion(InstitucionModelo institucion,String rut){
        inst = institucionServicio.addInstitucion(institucion);
        log.info("Se ha guardado una nueva institucion: ID:{}, Nombre:{}. Agregado por rut:{}",inst.getId_institucion(),inst.getNombre_institucion(),rut);
        return inst;
    }
}
