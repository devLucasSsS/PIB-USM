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
