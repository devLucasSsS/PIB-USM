package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class EstadoModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado;
    @Column(name = "estado",length = 45)
    private String estado;

    public EstadoModelo() {
    }

    public EstadoModelo(int id_estado, String estado) {
        this.id_estado = id_estado;
        this.estado = estado;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
