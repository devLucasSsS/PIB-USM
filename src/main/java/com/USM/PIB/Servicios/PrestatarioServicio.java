package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Modelos.Prestatario;
import com.USM.PIB.Repositorios.PrestatarioRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestatarioServicio {
    @Autowired
    PrestatarioRepositorio prestatarioRepositorio;
    private static final Logger log = (Logger) LoggerFactory.getLogger(Prestatario.class);

    public Prestatario savePrestatario(Prestatario prestatario){

        Prestatario p = prestatarioRepositorio.save(prestatario);
        log.info("Se ha agregado un nuevo prestatario: {}",p);
        return p;
    }

    public String getEmailByRut(String rut) {
        return prestatarioRepositorio.getEmailByRut(rut);
    }

    public Prestatario getByRut(String rutPrestatario) {
        return prestatarioRepositorio.findByRut(rutPrestatario);
    }
    public Prestatario updatePrestatario(String rut,Prestatario prestatario){
        Prestatario p = getByRut(rut);
        p.setRut_prestatario(prestatario.getRut_prestatario());
        p.setEmail(prestatario.getEmail());
        p.setNombre(p.getNombre());
        log.info("Se ha actualizado el prestatario: {}, nuevos cambios:{}",prestatario.toString(),p.toString());
        return prestatarioRepositorio.save(p);

    }
}
