package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.MensajesModelo;
import com.USM.PIB.Repositorios.MensajesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MensajesServicio {
    @Autowired
    MensajesRepositorio mensajesRepositorio;

    public ArrayList<MensajesModelo> getMensajesById(int id){
        return mensajesRepositorio.getMensajesByIdP(id);
    }

    public MensajesModelo saveMensaje(MensajesModelo mensaje) {
        return mensajesRepositorio.save(mensaje);
    }
}
