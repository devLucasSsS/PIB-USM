package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Servicios.GestorServicio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@RestController
@RequestMapping("/gestor")
public class GestorControlador {
    @Autowired
    private GestorServicio gestorServicio;
    @GetMapping()
    public GestorModelo getDataSession(HttpSession session){
        GestorModelo dat = (GestorModelo) session.getAttribute("gestor");
        if(dat != null){
            GestorModelo g = new GestorModelo();
            g.setRut_gestor(dat.getRut_gestor());
            g.setId_biblioteca(dat.getId_biblioteca());
            g.setId_nivel(dat.getId_nivel());
            g.setNombre(dat.getNombre());
            return g;
        }else{
            return null;
        }
    }
    @GetMapping(path = "/{rut}")
    public GestorModelo getGestorByrut(@PathVariable("rut") String rut){
        return gestorServicio.getByRut(rut);
    }

    @PostMapping
    public GestorModelo addGestor(GestorModelo gestor){
        return gestorServicio.addGestor(gestor);
    }

    @GetMapping(path = "/bib/{id}")
    public ArrayList<GestorModelo> getGestorByBib(@PathVariable("id")int id){
        return gestorServicio.getByBib(id);
    }
    @PostMapping(path = "/d/{rut}")
    public void deshabilitarRevisor(@PathVariable("rut") String rut){
        gestorServicio.deshabilitarRevisor(rut);
    }
}
