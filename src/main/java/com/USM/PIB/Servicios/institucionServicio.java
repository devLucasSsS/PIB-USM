package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.institucionModelo;
import com.USM.PIB.Repositorios.institucionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class institucionServicio {
    @Autowired
    institucionRepositorio institucionRepositorio;

    public ArrayList<institucionModelo> getInstituciones(){
        return (ArrayList<institucionModelo>) institucionRepositorio.findAll();
    }
}
