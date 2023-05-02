package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.peticion;
import com.USM.PIB.Modelos.prestatario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/")
public class vistaControlador {
    @Autowired

    @GetMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(){
        return new ModelAndView("nuevoFormulario").addObject("peticion",new peticion()).addObject("prestatario", new prestatario());
    }
    /*
    @PostMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(@RequestBody peticion peticion, @RequestBody prestatario prestatario){


    }*/
}
