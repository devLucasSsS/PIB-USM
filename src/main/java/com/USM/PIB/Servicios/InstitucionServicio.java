package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.InstitucionModelo;
import com.USM.PIB.Repositorios.InstitucionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InstitucionServicio {
    @Autowired
    InstitucionRepositorio institucionRepositorio;

    public ArrayList<InstitucionModelo> getInstituciones(){
        return (ArrayList<InstitucionModelo>) institucionRepositorio.findAll();
    }
    public InstitucionModelo getInstitucionById(int id){
        return institucionRepositorio.getInstitucionById(id);
    }
}
