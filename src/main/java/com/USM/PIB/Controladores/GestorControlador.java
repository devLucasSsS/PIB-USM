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


@RestController
@RequestMapping("/gestor")
public class GestorControlador {
    @GetMapping()
    public GestorModelo getDataSession(HttpSession session){
        GestorModelo dat = (GestorModelo) session.getAttribute("gestor");
        GestorModelo g = new GestorModelo();
        g.setRut_gestor(dat.getRut_gestor());
        g.setId_biblioteca(dat.getId_biblioteca());
        g.setId_nivel(dat.getId_nivel());
        return g;
    }
}
