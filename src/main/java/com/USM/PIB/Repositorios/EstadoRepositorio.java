package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.EstadoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepositorio extends JpaRepository<EstadoModelo,Integer> {
    @Query("SELECT e FROM EstadoModelo e where e.id_estado=?1")
    EstadoModelo getEstadoById(int id);
}
