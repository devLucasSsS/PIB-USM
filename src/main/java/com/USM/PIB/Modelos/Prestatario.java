package com.USM.PIB.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestatario")
public class Prestatario {
    @Id
    @Column(length = 13)
    private String rut_prestatario;
    @Column(length = 45)
    private String nombre;
    @Column()
    private String email;

    public Prestatario() {
    }

    public Prestatario(String rut_prestatario, String nombre, String email) {
        this.rut_prestatario = rut_prestatario;
        this.nombre = nombre;
        this.email = email;
    }

    public String getRut_prestatario() {
        return rut_prestatario;
    }

    public void setRut_prestatario(String rut_prestatario) {
        this.rut_prestatario = rut_prestatario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Prestatario{" +
                "rut_prestatario='" + rut_prestatario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
