package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.EstadoModelo;
import com.USM.PIB.Repositorios.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.util.ArrayList;

@Service
public class EstadoServicio {
    @Autowired
    EstadoRepositorio estadoRepositorio;

    public EstadoModelo getEstado(int id){
        return estadoRepositorio.getEstadoById(id);
    }

    public ArrayList<EstadoModelo> getEstadosPrestatario(){
        return estadoRepositorio.getEstadosPrestatario();
    }
    public ArrayList<EstadoModelo> getEstadosPrestador(){
        return estadoRepositorio.getEstadosPrestador();
    }
}
