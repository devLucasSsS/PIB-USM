package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "gestor")
public class gestor {
    @Id
    @Column(length = 13)
    private String rut_gestor;
    @OneToOne
    @JoinColumn(name = "id_nivel")
    private nivel_gestor id_nivel;
    @Column
    private String contraseña;
    @ManyToOne
    @JoinColumn(name = "id_biblioteca")
    private BibliotecaModelo id_biblioteca;

    public String getRut_gestor() {
        return rut_gestor;
    }

    public void setRut_gestor(String rut_gestor) {
        this.rut_gestor = rut_gestor;
    }

    public gestor() {

    }


    public void setId_nivel(nivel_gestor id_nivel) {
        this.id_nivel = id_nivel;
    }

    public BibliotecaModelo getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(BibliotecaModelo id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }
}
