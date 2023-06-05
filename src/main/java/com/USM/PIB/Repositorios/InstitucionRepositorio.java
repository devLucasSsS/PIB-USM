package com.USM.PIB.Repositorios;
import com.USM.PIB.Modelos.InstitucionModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionRepositorio extends JpaRepository<InstitucionModelo,Integer> {

    @Query("SELECT i from InstitucionModelo i WHERE i.id_institucion=?1")
    InstitucionModelo getInstitucionById(int id);

    @Query("SELECT i from InstitucionModelo i WHERE i.nombre_institucion=?1")
    boolean getInstitucionByNombre(String nombre);
}
