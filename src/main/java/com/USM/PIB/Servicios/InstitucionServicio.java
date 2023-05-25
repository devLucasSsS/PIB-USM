package com.USM.PIB.Servicios;

import com.USM.PIB.Controladores.RespuestaPersonalizadaControlador;
import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Modelos.InstitucionModelo;
import com.USM.PIB.Repositorios.InstitucionRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class InstitucionServicio {
    @Autowired
    InstitucionRepositorio institucionRepositorio;
    @Autowired
    RespuestaPersonalizadaControlador respuestaPersonalizadaControlador;
    public ArrayList<InstitucionModelo> getInstituciones(){
        return (ArrayList<InstitucionModelo>) institucionRepositorio.findAll();
    }
    public InstitucionModelo getInstitucionById(int id){
        return institucionRepositorio.getInstitucionById(id);
    }

    public InstitucionModelo addInstitucion(InstitucionModelo institucion) {
        return institucionRepositorio.save(institucion);
    }
}
