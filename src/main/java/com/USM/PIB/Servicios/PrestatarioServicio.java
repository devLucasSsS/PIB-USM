package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Modelos.Prestatario;
import com.USM.PIB.Repositorios.PrestatarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestatarioServicio {
    @Autowired
    PrestatarioRepositorio prestatarioRepositorio;

    public Prestatario savePrestatario(Prestatario prestatario){
        return prestatarioRepositorio.save(prestatario);
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
        return prestatarioRepositorio.save(p);

    }
}
