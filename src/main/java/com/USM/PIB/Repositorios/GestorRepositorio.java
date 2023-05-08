package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.GestorModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GestorRepositorio extends JpaRepository<GestorModelo,Integer> {
    @Query("SELECT g FROM GestorModelo g WHERE g.rut_gestor=?1 AND g.password=?2")
    GestorModelo login(String rut, String password);

    @Query("SELECT g FROM GestorModelo g WHERE g.rut_gestor=?1")
    GestorModelo findByRut(String rut);
}
