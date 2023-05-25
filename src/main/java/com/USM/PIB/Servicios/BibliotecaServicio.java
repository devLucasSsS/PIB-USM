package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.BibliotecaModelo;
import com.USM.PIB.Repositorios.BibliotecaRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class BibliotecaServicio {
    @Autowired
    BibliotecaRepositorio bibliotecaRepositorio;

    public ArrayList<BibliotecaModelo> getBibliotecas(){
        return (ArrayList<BibliotecaModelo>) bibliotecaRepositorio.findAll();
    }
    public ArrayList<BibliotecaModelo> getBibliotecasByInstitucion(int id){
        return (ArrayList<BibliotecaModelo>) bibliotecaRepositorio.findByInstitucion(id);
    }
    public BibliotecaModelo getBibliotecaById(int id) {
            BibliotecaModelo bib = bibliotecaRepositorio.findByIdB(id);
            return bib;
            /*if (bib == null){
            }
        }catch (Exception e){
            log.error("Error lol..",e);
            return null;
        }*/
    }

    public BibliotecaModelo addBibliotecas(BibliotecaModelo bibliotecaModelo) {
        return bibliotecaRepositorio.save(bibliotecaModelo);
    }

    public void deshabilitarBiblioteca(int id) {
        BibliotecaModelo bib = getBibliotecaById(id);
        bib.setHabilitado(0);
        bibliotecaRepositorio.save(bib);
    }
}
