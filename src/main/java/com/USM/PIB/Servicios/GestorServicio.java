package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.BibliotecaModelo;
import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Repositorios.GestorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GestorServicio {
    @Autowired
    GestorRepositorio gestorRepositorio;

    public GestorModelo login(String rut, String password){
        BCryptPasswordEncoder hash = new BCryptPasswordEncoder();
        GestorModelo user = getByRut(rut);
        if(hash.matches(password,user.getPassword())){
            return user;
        }else {
            return null;
        }
    }

    public GestorModelo getData(String rut){
        return gestorRepositorio.findByRut(rut);
    }

    public GestorModelo getByRut(String rut) {
        return gestorRepositorio.findByRut(rut);
    }

    public GestorModelo addGestor(GestorModelo gestor) {
        BCryptPasswordEncoder hash = new BCryptPasswordEncoder();
        String pwhash = hash.encode(gestor.getPassword());
        gestor.setPassword(pwhash);
        return gestorRepositorio.save(gestor);
    }

    public ArrayList<GestorModelo> getByBib(int id) {
        return gestorRepositorio.getByBib(id);
    }

    public void deshabilitarRevisor(String rut) {
            GestorModelo g = getByRut(rut);
            g.setHabilitado(0);
            gestorRepositorio.save(g);
    }

    public ArrayList<GestorModelo> getByInst(int id, String rut) {
        return gestorRepositorio.getByInst(id,rut);
    }
}
