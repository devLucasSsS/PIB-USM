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
}
