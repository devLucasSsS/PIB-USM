package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.Tipo_envioModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_envioRepositorio extends JpaRepository<Tipo_envioModelo,Integer> {
    @Query("SELECT t FROM Tipo_envioModelo t WHERE t.tipo_envio=?1")
    Tipo_envioModelo getByIdTerm(int tipoEnvio);
}
