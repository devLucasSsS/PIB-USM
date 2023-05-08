package com.USM.PIB.Repositorios;


import com.USM.PIB.Modelos.Tipo_itemModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_itemRepositorio extends JpaRepository<Tipo_itemModelo,Integer> {
}
