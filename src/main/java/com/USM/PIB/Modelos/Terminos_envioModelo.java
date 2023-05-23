package com.USM.PIB.Modelos;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "terminos_envio")
public class Terminos_envioModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_envio;

    @Column
    private int tipo_envio;
    @Column
    private String terminos;
    @Column
    private String descripcion_envio;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fecha_vencimiento;
    @Column
    private byte envio;
    @Column
    private int id_peticion;

    public int getId_peticion() {
        return id_peticion;
    }

    public void setId_peticion(int id_peticion) {
        this.id_peticion = id_peticion;
    }

    public byte getEnvio() {
        return envio;
    }

    public void setEnvio(byte envio) {
        this.envio = envio;
    }

    public Terminos_envioModelo() {
    }

    public int getTipo_envio() {
        return tipo_envio;
    }

    public void setTipo_envio(int tipo_envio) {
        this.tipo_envio = tipo_envio;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Terminos_envioModelo(int id_envio, int tipo_envio, String terminos, String descripcion_envio, Date fecha_vencimiento, byte envio, int id_peticion) {
        this.id_envio = id_envio;
        this.tipo_envio = tipo_envio;
        this.terminos = terminos;
        this.descripcion_envio = descripcion_envio;
        this.fecha_vencimiento = fecha_vencimiento;
        this.envio = envio;
        this.id_peticion = id_peticion;
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
