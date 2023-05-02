package com.USM.PIB.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.USM.PIB.Modelos.institucionModelo;
public interface institucionRepositorio extends JpaRepository<institucionModelo,Integer> {
}
