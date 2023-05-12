package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_envio")
public class Tipo_envioModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipo_envio;
    @Column
    private String tipo;

    public Tipo_envioModelo() {
    }

    public Tipo_envioModelo(int tipo_envio, String tipo) {
        this.tipo_envio = tipo_envio;
        this.tipo = tipo;
    }

    public int getTipo_envio() {
        return tipo_envio;
    }

    public void setTipo_envio(int tipo_envio) {
        this.tipo_envio = tipo_envio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
