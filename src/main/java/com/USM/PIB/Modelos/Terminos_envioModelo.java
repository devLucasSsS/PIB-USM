package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "terminos_envio")
public class Terminos_envioModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_envio;

    @Column
    private int tipo_envio;
    @Column
    private String terminos;
    @Column
    private String descripcion_envio;

    public Terminos_envioModelo() {
    }

    public int getTipo_envio() {
        return tipo_envio;
    }

    public void setTipo_envio(int tipo_envio) {
        this.tipo_envio = tipo_envio;
    }

    public Terminos_envioModelo(int id_envio, int tipo_envio, String terminos, String descripcion_envio) {
        this.id_envio = id_envio;
        this.tipo_envio = tipo_envio;
        this.terminos = terminos;
        this.descripcion_envio = descripcion_envio;
    }

    public String getDescripcion_envio() {
        return descripcion_envio;
    }

    public void setDescripcion_envio(String descripcion_envio) {
        this.descripcion_envio = descripcion_envio;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }



    public String getTerminos() {
        return terminos;
    }

    public void setTerminos(String terminos) {
        this.terminos = terminos;
    }
}
