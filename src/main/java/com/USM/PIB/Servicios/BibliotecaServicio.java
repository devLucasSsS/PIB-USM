package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.BibliotecaModelo;
import com.USM.PIB.Repositorios.BibliotecaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BibliotecaServicio {
    @Autowired
    BibliotecaRepositorio bibliotecaRepositorio;

    public ArrayList<BibliotecaModelo> getBibliotecas(){
        return (ArrayList<BibliotecaModelo>) bibliotecaRepositorio.findAll();
    }
    public ArrayList<BibliotecaModelo> getBibliotecasByInstitucion(int id){
        return (ArrayList<BibliotecaModelo>) bibliotecaRepositorio.findByInstitucion(id);
    }

    public BibliotecaModelo getBibliotecaByIdPeticion(int id) {
        return bibliotecaRepositorio.getByIdPeticion(id);
    }
}
