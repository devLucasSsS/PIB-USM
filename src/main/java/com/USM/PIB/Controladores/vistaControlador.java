package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.*;
import com.USM.PIB.Servicios.BibliotecaServicio;
import com.USM.PIB.Servicios.GestorServicio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
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
    private BibliotecaServicio bibliotecaServicio;
    @Autowired
    private PeticionControlador peticionControlador;
    @Autowired
    private PrestatarioControlador prestatarioControlador;
    @Autowired
    private GestorControlador gestorControlador;
    @Autowired
    private GestorServicio gestorServicio;
    @GetMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(){
        ArrayList<institucionModelo> institucion = institucionServicio.getInstituciones();
        ArrayList<BibliotecaModelo> bibliotecas = bibliotecaServicio.getBibliotecas();
        return new ModelAndView("nuevoFormulario")
                .addObject("peticion",new Peticion())
                .addObject("prestatario", new Prestatario())
                .addObject("institucion",institucion)
                .addObject("bibliotecas",bibliotecas);
    }
    @PostMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(Peticion peticion, Prestatario prestatario){
        peticionControlador.savePeticion(peticion);
        prestatarioControlador.savePrestatario(prestatario);
        return new ModelAndView("redirect:/peticiones");
    }

    @GetMapping(path = "peticiones")
    public ModelAndView peticiones(){
        ArrayList<Peticion> pet = peticionControlador.getPeticiones();
        return new ModelAndView("formularios").addObject("peticiones",pet);
    }
    @GetMapping(path = "login")
    public ModelAndView login(){
        return new ModelAndView("login").addObject("gestor",new GestorModelo());
    }
    @PostMapping(path = "login")
    public ModelAndView login(GestorModelo gestor, HttpServletRequest request){
        GestorModelo response = gestorServicio.login(gestor.getRut_gestor(),gestor.getPassword());
        if (response!=null){
            GestorModelo g = gestorServicio.getData(gestor.getRut_gestor());
            HttpSession sesion = request.getSession();
            request.setAttribute("gestor",g);
        }
        return new ModelAndView("redirect:/peticiones");
    }
}
