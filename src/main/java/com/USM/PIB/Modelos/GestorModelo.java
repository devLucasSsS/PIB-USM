package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "gestor")
public class GestorModelo {
    @Id
    @Column(length = 13)
    private String rut_gestor;
    @Column
    private int id_nivel;
    @Column
    private String password;
    @Column
    private int id_biblioteca;
    @Column
    private String nombre;
    @Column
    private int habilitado;
    @Column
    private int id_institucion;
    @Column
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(int id_institucion) {
        this.id_institucion = id_institucion;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GestorModelo(String rut_gestor, int id_nivel, String password, int id_biblioteca, String nombre, int habilitado, int id_institucion, String email) {
        this.rut_gestor = rut_gestor;
        this.id_nivel = id_nivel;
        this.password = password;
        this.id_biblioteca = id_biblioteca;
        this.nombre = nombre;
        this.habilitado = habilitado;
        this.id_institucion = id_institucion;
        this.email = email;
    }

    public String getRut_gestor() {
        return rut_gestor;
    }

    public void setRut_gestor(String rut_gestor) {
        this.rut_gestor = rut_gestor;
    }

    public GestorModelo() {

    }


    public int getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(int id_nivel) {
        this.id_nivel = id_nivel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }
}
