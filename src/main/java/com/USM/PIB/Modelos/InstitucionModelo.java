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
    @Column(length = 10)
    private String siglas_institucion;

    public String getSiglas_institucion() {
        return siglas_institucion;
    }

    public void setSiglas_institucion(String siglas_institucion) {
        this.siglas_institucion = siglas_institucion;
    }

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

    public InstitucionModelo(int id_institucion, String nombre_institucion, String siglas_institucion) {
        this.id_institucion = id_institucion;
        this.nombre_institucion = nombre_institucion;
        this.siglas_institucion = siglas_institucion;
    }
}
