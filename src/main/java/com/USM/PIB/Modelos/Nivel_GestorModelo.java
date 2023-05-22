package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "nivel_gestor")
public class Nivel_GestorModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_nivel;
    @Column(length = 45)
    private String nivel;

    public Nivel_GestorModelo() {
    }

    public Nivel_GestorModelo(int id_nivel, String nivel) {
        this.id_nivel = id_nivel;
        this.nivel = nivel;
    }

    public int getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(int id_nivel) {
        this.id_nivel = id_nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
