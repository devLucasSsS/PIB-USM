package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.Tipo_envioModelo;
import com.USM.PIB.Modelos.Tipo_itemModelo;
import com.USM.PIB.Repositorios.Tipo_envioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Tipo_envioServicio {

    @Autowired
    Tipo_envioRepositorio tipoEnvioRepositorio;

    public Tipo_envioModelo getByIdTerm(int tipoEnvio) {
        return tipoEnvioRepositorio.getByIdTerm(tipoEnvio);
    }

    public Tipo_envioModelo saveTipoEnvio(Tipo_envioModelo tipoEnvio){
        return tipoEnvioRepositorio.save(tipoEnvio);
    }

    public ArrayList<Tipo_envioModelo> getTipos() {
        return (ArrayList<Tipo_envioModelo>) tipoEnvioRepositorio.findAll();
    }
}
