package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "biblioteca")
public class bibliotecaModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_biblioteca;
    @Column(length = 45)
    private String nombre_biblioteca;
    @ManyToOne
    @JoinColumn(name = "id_institucion")
    private institucionModelo id_institucion;

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public String getNombre_biblioteca() {
        return nombre_biblioteca;
    }

    public void setNombre_biblioteca(String nombre_biblioteca) {
        this.nombre_biblioteca = nombre_biblioteca;
    }

    public institucionModelo getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(institucionModelo id_institucion) {
        this.id_institucion = id_institucion;
    }

}
