package com.USM.PIB.Repositorios;

import com.USM.PIB.Modelos.Peticion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface PeticionRepositorio extends JpaRepository<Peticion,Integer> {
    @Query("SELECT p FROM Peticion p WHERE p.id_biblioteca_prestataria=?1")
    ArrayList<Peticion> findByBibliotecaPrestataria(int id);
    @Query("SELECT p FROM Peticion p WHERE p.id_biblioteca_prestadora=?1 AND p.id_estado >= 4")
    ArrayList<Peticion> findByBibliotecaPrestadora(int id);

    // Obtener la cantidad total de peticiones
    long count();

    // Obtener la cantidad de peticiones con estado 16
    @Query("SELECT COUNT(p) FROM Peticion p WHERE p.id_estado = 16")
    int countPeticionesEstado16();


    default int obtenerCantidadTotalPeticionesDesdeFecha(Date fechaDesde) {
        return countByFechaPeticionGreaterThanEqual(fechaDesde);
    }

    @Query("SELECT COUNT(p) FROM Peticion p WHERE p.fecha_peticion >= :fecha_peticion")
    int countByFechaPeticionGreaterThanEqual(Date fecha_peticion);
}
