package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.bibliotecaModelo;
import com.USM.PIB.Modelos.institucionModelo;
import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Modelos.Prestatario;
import com.USM.PIB.Servicios.bibliotecaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class vistaControlador {
    @Autowired
    private com.USM.PIB.Servicios.institucionServicio institucionServicio;
    @Autowired
    private bibliotecaServicio bibliotecaServicio;
    @Autowired
    private PeticionControlador peticionControlador;
    @Autowired
    private PrestatarioControlador prestatarioControlador;
    @GetMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(){
        ArrayList<institucionModelo> institucion = institucionServicio.getInstituciones();
        ArrayList<bibliotecaModelo> bibliotecas = bibliotecaServicio.getBibliotecas();
        return new ModelAndView("nuevoFormulario")
                .addObject("peticion",new Peticion())
                .addObject("prestatario", new Prestatario())
                .addObject("institucion",institucion)
                .addObject("bibliotecas",bibliotecas);
    }
    @PostMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(Peticion peticion){
        peticionControlador.savePeticion(peticion);
        //prestatarioControlador.savePrestatario(prestatario);
        return new ModelAndView("redirect:/peticion/nueva");
    }

    @GetMapping(path = "peticiones")
    public ModelAndView peticiones(){
        ArrayList<Peticion> pet = peticionControlador.getPeticiones();
        return new ModelAndView("formularios").addObject("peticiones",pet);
    }
}
