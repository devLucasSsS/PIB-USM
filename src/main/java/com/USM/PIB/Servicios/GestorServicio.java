package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.BibliotecaModelo;
import com.USM.PIB.Modelos.GestorModelo;
import com.USM.PIB.Repositorios.GestorRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class GestorServicio {
    @Autowired
    GestorRepositorio gestorRepositorio;
    private static final Logger log = (Logger) LoggerFactory.getLogger(GestorModelo.class);
    public GestorModelo login(String rut, String password){
        BCryptPasswordEncoder hash = new BCryptPasswordEncoder();
        GestorModelo user = getByRut(rut);
        if(user != null){
            if(hash.matches(password,user.getPassword())){
                log.info("Inicio de sesión correcto Rut:{}, Nombre:{}, IdBib:{}, IdInst:{}",user.getRut_gestor(),user.getNombre(),user.getId_biblioteca(),user.getId_institucion());
                return user;
            }else {
                log.info("Inicio de sesión fallido Rut:{}",rut);
                return null;
            }
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

    public GestorModelo addGestor(GestorModelo gestor,String rut_Gestor) {
        BCryptPasswordEncoder hash = new BCryptPasswordEncoder();
        String pwhash = hash.encode(gestor.getPassword());
        gestor.setPassword(pwhash);
        GestorModelo g= gestorRepositorio.save(gestor);
        log.info("Se ha guardado un nuevo gestor/revisor: Rut:{}, Nombre:{}, Contrasenia:{}, Correo:{}, Id_Bib:{}, Id_Inst:{}, Id_Nivel:{}, Habilitado:{}. Agregado por Rut:{}",
                g.getRut_gestor(),
                g.getNombre(),
                g.getPassword(),
                g.getEmail(),
                g.getId_biblioteca(),
                g.getId_institucion(),
                g.getId_nivel(),
                g.getHabilitado(),
                rut_Gestor);
        return g;
    }

    public ArrayList<GestorModelo> getByBib(int id) {
        return gestorRepositorio.getByBib(id);
    }

    public void deshabilitarRevisor(String rut,String rutGestor) {
            GestorModelo g = getByRut(rut);
            g.setHabilitado(0);
            gestorRepositorio.save(g);
            log.info("Se ha deshabilitado el siguiente gestor: Rut={}, Nombre={}, IdBib:{}. Deshabilitado por rut:{}",g.getRut_gestor(),g.getNombre(),g.getId_biblioteca(),rutGestor);
    }

    public ArrayList<GestorModelo> getByInst(int id, String rut) {
        return gestorRepositorio.getByInst(id,rut);
    }

    public ArrayList<GestorModelo> getRevisorByBib(int id) {
        return gestorRepositorio.getRevisorById(id);
    }
}
