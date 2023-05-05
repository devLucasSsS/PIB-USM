package com.USM.PIB.Modelos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "mensajes")
public class mensajes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_mensaje;
    @Column
    private String mensaje;
    @Column
    private Date fecha_mensaje;
    @Column
    private String rut_gestor;
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_peticion")
    private Peticion id_peticion;

    public mensajes() {
    }

    public String getRut_gestor() {
        return rut_gestor;
    }

    public void setRut_gestor(String rut_gestor) {
        this.rut_gestor = rut_gestor;
    }

    public mensajes(int id_mensaje, String mensaje, Date fecha_mensaje, String rut_gestor, Peticion id_peticion) {
        this.id_mensaje = id_mensaje;
        this.mensaje = mensaje;
        this.fecha_mensaje = fecha_mensaje;
        this.rut_gestor = rut_gestor;
        this.id_peticion = id_peticion;
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(Date fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }



    public Peticion getId_peticion() {
        return id_peticion;
    }

    public void setId_peticion(Peticion id_peticion) {
        this.id_peticion = id_peticion;
    }
}
