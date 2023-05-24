package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.EstadoModelo;
import com.USM.PIB.Servicios.EstadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Controller
@RestController
@RequestMapping("estado")
public class EstadoControlador {

    @Autowired
    EstadoServicio  estadoServicio;

    @GetMapping(path = "/{id}")
    public EstadoModelo getEstadoById(@PathVariable("id")int id){
        return estadoServicio.getEstado(id);
    }

    @GetMapping(path = "/prestatario")
    public ArrayList<EstadoModelo> getEstadosPrestatario(){
        return estadoServicio.getEstadosPrestatario();
    }
    @GetMapping(path = "/prestador")
    public ArrayList<EstadoModelo> getEstadoPrestador(){
        return estadoServicio.getEstadosPrestador();
    }

    @GetMapping
    public ArrayList<EstadoModelo> getEstados(){
        return estadoServicio.getEstados();
    }
}
