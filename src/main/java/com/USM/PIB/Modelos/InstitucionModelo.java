package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "institucion")
public class InstitucionModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_institucion;
    @Column
    private String nombre_institucion;


    public InstitucionModelo() {
    }

    public int getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(int id_institucion) {
        this.id_institucion = id_institucion;
    }

    public String getNombre_institucion() {
        return nombre_institucion;
    }

    public void setNombre_institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }

}