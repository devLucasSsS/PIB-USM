package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.GestorModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface GestorRepositorio extends JpaRepository<GestorModelo,Integer> {
    @Query("SELECT g FROM GestorModelo g WHERE g.rut_gestor=?1 AND g.password=?2 AND g.habilitado=1")
    GestorModelo login(String rut, String password);

    @Query("SELECT g FROM GestorModelo g WHERE g.rut_gestor=?1 AND g.habilitado=1")
    GestorModelo findByRut(String rut);

    @Query("SELECT g FROM GestorModelo g WHERE g.id_biblioteca=?1 AND g.habilitado=1")
    ArrayList<GestorModelo> getByBib(int id);
}
