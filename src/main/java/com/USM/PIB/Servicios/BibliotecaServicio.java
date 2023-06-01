package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.BibliotecaModelo;
import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Modelos.Peticion;
import com.USM.PIB.Repositorios.BibliotecaRepositorio;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class BibliotecaServicio {
    @Autowired
    BibliotecaRepositorio bibliotecaRepositorio;
    private static final Logger log = (Logger) LoggerFactory.getLogger(BibliotecaModelo.class);

    public ArrayList<BibliotecaModelo> getBibliotecas(){
        return (ArrayList<BibliotecaModelo>) bibliotecaRepositorio.findAll();
    }
    public ArrayList<BibliotecaModelo> getBibliotecasByInstitucion(int id){
        return (ArrayList<BibliotecaModelo>) bibliotecaRepositorio.findByInstitucion(id);
    }
    public BibliotecaModelo getBibliotecaById(int id) {
            BibliotecaModelo bib = bibliotecaRepositorio.findByIdB(id);
            return bib;
    }

    public BibliotecaModelo addBibliotecas(BibliotecaModelo bibliotecaModelo, String rut) {

        BibliotecaModelo bib= bibliotecaRepositorio.save(bibliotecaModelo);
        log.info("Nueva Biblioteca Agregada al sistema: {} por Rut:{}",bib,rut);
        return bib;
    }

    public void deshabilitarBiblioteca(int id,String rut) {
        BibliotecaModelo bib = getBibliotecaById(id);
        bib.setHabilitado(0);
        log.info("Biblioteca Id:{} se ha deshabilitado por el rut:{}",bib.getId_biblioteca(),rut);
        bibliotecaRepositorio.save(bib);
    }
}
