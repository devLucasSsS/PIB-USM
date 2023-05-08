package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.Tipo_itemModelo;
import com.USM.PIB.Repositorios.Tipo_itemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Tipo_itemServicio {
    @Autowired
    Tipo_itemRepositorio tipoItemRepositorio;
    public ArrayList<Tipo_itemModelo> getTiposItem(){
        return (ArrayList<Tipo_itemModelo>) tipoItemRepositorio.findAll();
    }
}
