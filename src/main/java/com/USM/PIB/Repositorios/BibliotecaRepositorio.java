package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.BibliotecaModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface BibliotecaRepositorio extends JpaRepository<BibliotecaModelo,Integer> {
    @Query("SELECT b FROM BibliotecaModelo b WHERE b.id_institucion=?1")
    ArrayList<BibliotecaModelo> findByInstitucion(int id);
    @Query("SELECT b FROM BibliotecaModelo b WHERE b.id_biblioteca=?1")
    BibliotecaModelo findByIdB(int id);
}
