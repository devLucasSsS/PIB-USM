package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.EstadoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EstadoRepositorio extends JpaRepository<EstadoModelo,Integer> {
    @Query("SELECT e FROM EstadoModelo e where e.id_estado=?1")
    EstadoModelo getEstadoById(int id);
    @Query("SELECT e from EstadoModelo e where e.id_estado BETWEEN 8 AND 9")
    ArrayList<EstadoModelo> getEstadosPrestatario();
    @Query("SELECT e from EstadoModelo e where e.id_estado BETWEEN 10 AND 13")
    ArrayList<EstadoModelo> getEstadosPrestador();
}
