package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.Terminos_envioModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Terminos_EnvioRepositorio extends JpaRepository<Terminos_envioModelo,Integer> {
    @Query("SELECT t FROM Terminos_envioModelo t WHERE t.id_peticion =?1 AND envio=0")
    Terminos_envioModelo getByIdPet0(int idPeticion);
        @Query("SELECT t FROM Terminos_envioModelo t WHERE t.id_peticion =?1 AND envio=1 ORDER BY t.id_envio DESC LIMIT 1")
        Terminos_envioModelo getByIdPet1(int idPeticion);
}
