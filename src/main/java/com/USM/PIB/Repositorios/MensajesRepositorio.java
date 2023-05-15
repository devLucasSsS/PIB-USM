package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.MensajesModelo;
import com.USM.PIB.Modelos.Peticion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MensajesRepositorio extends JpaRepository<MensajesModelo,Integer> {
    @Query("SELECT m FROM MensajesModelo m WHERE m.id_peticion=?1")
    ArrayList<MensajesModelo> getMensajesByIdP(int id);
}
