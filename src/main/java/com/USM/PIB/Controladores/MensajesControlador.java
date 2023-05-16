package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.MensajesModelo;
import com.USM.PIB.Servicios.MensajesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("mensajes")
public class MensajesControlador {
    @Autowired
    MensajesServicio mensajesServicio;
    @GetMapping
    public ArrayList<MensajesModelo> getMensajesById(int id){
        return mensajesServicio.getMensajesById(id);
    }
    @PostMapping
    public MensajesModelo saveMensaje(MensajesModelo mensaje){
//        return mensajesServicio.saveMensaje(mensaje);
        return new ResponseEntity<>(mensajesServicio.saveMensaje(mensaje), HttpStatus.CREATED).getBody();

    }
}
