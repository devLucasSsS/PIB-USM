package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.Peticion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeticionRepositorio extends JpaRepository<Peticion,Integer> {
}
