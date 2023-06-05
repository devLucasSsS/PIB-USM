package com.USM.PIB.Servicios;
import com.USM.PIB.Controladores.RespuestaPersonalizadaControlador;
import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Modelos.InstitucionModelo;
import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Repositorios.InstitucionRepositorio;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
@Service
@Slf4j
public class InstitucionServicio {
    @Autowired
    InstitucionRepositorio institucionRepositorio;
    private static final Logger log = (Logger) LoggerFactory.getLogger(InstitucionModelo.class);
    public ArrayList<InstitucionModelo> getInstituciones(){
        return (ArrayList<InstitucionModelo>) institucionRepositorio.findAll();
    }
    public InstitucionModelo getInstitucionById(int id){
        InstitucionModelo inst = institucionRepositorio.getInstitucionById(id);
        if (inst!=null){
            return inst;
        }else {
            String mensaje = "Institucion con ID "+id+" no se encuentra";
            log.error(mensaje);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,mensaje);
        }
    }
    public InstitucionModelo addInstitucion(InstitucionModelo institucion,String rut) {
        boolean verificar = getInstitucionByNombre(institucion.getNombre_institucion());
        if (verificar == false){
            InstitucionModelo inst = institucionRepositorio.save(institucion);
            log.info("Se ha guardado una nueva institucion: ID:{}, Nombre:{}. Agregado por rut:{}",inst.getId_institucion(),inst.getNombre_institucion(),rut);
            return inst;
        }else {
            String mensaje = "Institucion con Nombre: "+institucion.getNombre_institucion()+" ya se encuentra registrado";
            log.error(mensaje);
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,mensaje);
        }
    }
    public boolean getInstitucionByNombre(String nombre){
        boolean inst = institucionRepositorio.getInstitucionByNombre(nombre);
       return inst;
    }
}
