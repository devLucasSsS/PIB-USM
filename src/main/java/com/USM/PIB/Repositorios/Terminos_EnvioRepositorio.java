package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.Terminos_envioModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Terminos_EnvioRepositorio extends JpaRepository<Terminos_envioModelo,Integer> {
    @Query("SELECT t FROM Terminos_envioModelo t WHERE t.id_envio =?1")
    Terminos_envioModelo getByIdPet(int idTerminosEnvio);
}
