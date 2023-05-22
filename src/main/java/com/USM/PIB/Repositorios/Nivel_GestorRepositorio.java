package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.Nivel_GestorModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface Nivel_GestorRepositorio extends JpaRepository<Nivel_GestorModelo,Integer> {

}
