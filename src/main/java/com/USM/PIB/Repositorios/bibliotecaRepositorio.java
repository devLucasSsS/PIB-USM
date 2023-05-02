package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.bibliotecaModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bibliotecaRepositorio extends JpaRepository<bibliotecaModelo,Integer> {
}
