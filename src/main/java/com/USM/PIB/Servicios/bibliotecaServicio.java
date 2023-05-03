package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.bibliotecaModelo;
import com.USM.PIB.Repositorios.bibliotecaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class bibliotecaServicio {
    @Autowired
    bibliotecaRepositorio bibliotecaRepositorio;

    public ArrayList<bibliotecaModelo> getBibliotecas(){
        return (ArrayList<bibliotecaModelo>) bibliotecaRepositorio.findAll();
    }
}
