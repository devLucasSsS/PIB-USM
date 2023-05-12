package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.*;
import com.USM.PIB.Servicios.BibliotecaServicio;
import com.USM.PIB.Servicios.GestorServicio;
import com.USM.PIB.Servicios.PeticionServicio;
import com.USM.PIB.Servicios.Tipo_itemServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

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
    @Autowired
    private Tipo_itemServicio tipoItemServicio;
    @Autowired
    private PeticionServicio peticionServicio;

    @GetMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(){
        ArrayList<institucionModelo> institucion = institucionServicio.getInstituciones();
        ArrayList<BibliotecaModelo> bibliotecas = bibliotecaServicio.getBibliotecas();
        ArrayList<Tipo_itemModelo> tipo_item = tipoItemServicio.getTiposItem();
        GestorModelo nivel = new GestorModelo();
        return new ModelAndView("nuevoFormulario")
                .addObject("peticion",new Peticion())
                .addObject("prestatario", new Prestatario())
                .addObject("institucion",institucion)
                .addObject("bibliotecas",bibliotecas)
                .addObject("tipo_item" ,tipo_item)
                .addObject("nivel",nivel)
                .addObject("miObjeto");
    }
    @PostMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(Peticion peticion, Prestatario prestatario){
        peticionControlador.savePeticion(peticion);
        //prestatarioControlador.savePrestatario(prestatario);
        return new ModelAndView("redirect:/peticiones");
    }
    @GetMapping(path = "peticion/{id}")
    public ModelAndView editarPeticion(@PathVariable("id") int id){
        Optional<Peticion> pet = peticionControlador.getPeticionById(id);
        return new ModelAndView("EditarPeticion")
                .addObject("peticion",pet)
                .addObject("terminos_envio",new Terminos_envioModelo())
                .addObject("tipo_envio",new Tipo_envioModelo());
    }
    @GetMapping(path = "peticiones")
    public ModelAndView peticiones(HttpSession session){
        GestorModelo data = gestorControlador.getDataSession(session);
        if(data!=null){
            ArrayList<Peticion> PetPrestatarias = peticionControlador.getPeticionByBibliotecasPrestataria(data.getId_biblioteca());
            ArrayList<Peticion> PetPrestadoras = peticionControlador.getPeticionByBibliotecasPrestadora(data.getId_biblioteca());
            return new ModelAndView("formularios").addObject("peticionesEntrantes",PetPrestadoras).addObject("peticionesSalientes",PetPrestatarias);
        }else{
            return new ModelAndView("redirect:/login");
        }

    }
    @GetMapping(path = "login")
    public ModelAndView login(){
        return new ModelAndView("login").addObject("gestor",new GestorModelo());
    }
    @PostMapping(path = "login")
    public ModelAndView login(GestorModelo gestor, HttpSession session){
        GestorModelo response = gestorServicio.login(gestor.getRut_gestor(),gestor.getPassword());
        if (response!=null){
            GestorModelo g = gestorServicio.getData(gestor.getRut_gestor());
            session.setAttribute("gestor",g);
            return new ModelAndView("redirect:/peticiones");
        }else{
            return new ModelAndView("redirect:/login");

        }
    }
    @GetMapping(path = "logout")
    public ModelAndView logout(HttpSession session){
        session.removeAttribute("gestor");
        return new ModelAndView("redirect:/login");
    }
}
