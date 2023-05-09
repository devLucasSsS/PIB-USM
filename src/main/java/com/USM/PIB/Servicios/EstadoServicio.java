package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.EstadoModelo;
import com.USM.PIB.Repositorios.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoServicio {
    @Autowired
    EstadoRepositorio estadoRepositorio;

    public EstadoModelo getEstado(int id){
        return estadoRepositorio.getEstadoById(id);
    }
}
