package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.Prestatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrestatarioRepositorio extends JpaRepository<Prestatario,Integer> {
    @Query("SELECT p.email FROM Prestatario p WHERE p.rut_prestatario=?1")
    String getEmailByRut(String rut);

    @Query("SELECT p FROM Prestatario p WHERE p.rut_prestatario=?1")
    Prestatario findByRut(String rutPrestatario);
}
