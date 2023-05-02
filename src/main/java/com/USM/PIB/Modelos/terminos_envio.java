package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "terminos_envio")
public class terminos_envio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_envio;
    @OneToOne
    @JoinColumn(name = "tipo_envio")
    private tipo_envio tipo_envio;
    @Column
    private String terminos;

    public terminos_envio() {
    }

    public terminos_envio(int id_envio, com.USM.PIB.Modelos.tipo_envio tipo_envio, String terminos) {
        this.id_envio = id_envio;
        this.tipo_envio = tipo_envio;
        this.terminos = terminos;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public com.USM.PIB.Modelos.tipo_envio getTipo_envio() {
        return tipo_envio;
    }

    public void setTipo_envio(com.USM.PIB.Modelos.tipo_envio tipo_envio) {
        this.tipo_envio = tipo_envio;
    }

    public String getTerminos() {
        return terminos;
    }

    public void setTerminos(String terminos) {
        this.terminos = terminos;
    }
}
