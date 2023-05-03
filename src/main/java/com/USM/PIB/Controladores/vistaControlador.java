package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.bibliotecaModelo;
import com.USM.PIB.Modelos.institucionModelo;
import com.USM.PIB.Modelos.peticion;
import com.USM.PIB.Modelos.prestatario;
import com.USM.PIB.Servicios.bibliotecaServicio;
import com.USM.PIB.Servicios.institucionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class vistaControlador {
    @Autowired
    private com.USM.PIB.Servicios.institucionServicio institucionServicio;
    @Autowired
    private bibliotecaServicio bibliotecaServicio;
    @GetMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(){
        ArrayList<institucionModelo> institucion = institucionServicio.getInstituciones();
        ArrayList<bibliotecaModelo> bibliotecas = bibliotecaServicio.getBibliotecas();
        return new ModelAndView("nuevoFormulario")
                //.addObject("peticion",new peticion())
                //.addObject("prestatario", new prestatario())
                .addObject("institucion",institucion)
                .addObject("bibliotecas",bibliotecas);
    }
    /*
    @PostMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(@RequestBody peticion peticion, @RequestBody prestatario prestatario){


    }*/
}
