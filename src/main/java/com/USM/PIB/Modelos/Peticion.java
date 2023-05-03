package com.USM.PIB.Modelos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "peticion")
public class Peticion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_peticion;
    @Column(length = 45)
    private String libro;
    @Column(length = 45)
    private String edicion;
    @Column(length = 45)
    private String autor;
    @Column(length = 255)
    private String link;
    @Column(length = 20)
    private String ip;
    @Column
    private Date fecha_peticion;
    @Column
    private Date fecha_prestamo;
    @Column
    private Date fecha_devolucion;
    @Column
    private String rut_prestatario;
    @Column
    private int id_biblioteca_prestataria;
    @Column
    private int id_institucion_prestataria;
    @Column
    private int id_biblioteca_prestadora;
    @Column
    private int id_institucion_prestadora;
    @Column
    private int id_estado;
    @Column
    private int id_terminos_envio;
    @Column
    private int id_item;

    public Peticion() {
    }

    public int getId_peticion() {
        return id_peticion;
    }

    public void setId_peticion(int id_peticion) {
        this.id_peticion = id_peticion;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getFecha_peticion() {
        return fecha_peticion;
    }

    public void setFecha_peticion(Date fecha_peticion) {
        this.fecha_peticion = fecha_peticion;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getRut_prestatario() {
        return rut_prestatario;
    }

    public void setRut_prestatario(String rut_prestatario) {
        this.rut_prestatario = rut_prestatario;
    }

    public int getId_biblioteca_prestataria() {
        return id_biblioteca_prestataria;
    }

    public void setId_biblioteca_prestataria(int id_biblioteca_prestataria) {
        this.id_biblioteca_prestataria = id_biblioteca_prestataria;
    }

    public int getId_institucion_prestataria() {
        return id_institucion_prestataria;
    }

    public void setId_institucion_prestataria(int id_institucion_prestataria) {
        this.id_institucion_prestataria = id_institucion_prestataria;
    }

    public int getId_biblioteca_prestadora() {
        return id_biblioteca_prestadora;
    }

    public void setId_biblioteca_prestadora(int id_biblioteca_prestadora) {
        this.id_biblioteca_prestadora = id_biblioteca_prestadora;
    }

    public int getId_institucion_prestadora() {
        return id_institucion_prestadora;
    }

    public void setId_institucion_prestadora(int id_institucion_prestadora) {
        this.id_institucion_prestadora = id_institucion_prestadora;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_terminos_envio() {
        return id_terminos_envio;
    }

    public void setId_terminos_envio(int id_terminos_envio) {
        this.id_terminos_envio = id_terminos_envio;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public Peticion(int id_peticion, String libro, String edicion, String autor, String link, String ip, Date fecha_peticion, Date fecha_prestamo, Date fecha_devolucion, String rut_prestatario, int id_biblioteca_prestataria, int id_institucion_prestataria, int id_biblioteca_prestadora, int id_institucion_prestadora, int id_estado, int id_terminos_envio, int id_item) {
        this.id_peticion = id_peticion;
        this.libro = libro;
        this.edicion = edicion;
        this.autor = autor;
        this.link = link;
        this.ip = ip;
        this.fecha_peticion = fecha_peticion;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.rut_prestatario = rut_prestatario;
        this.id_biblioteca_prestataria = id_biblioteca_prestataria;
        this.id_institucion_prestataria = id_institucion_prestataria;
        this.id_biblioteca_prestadora = id_biblioteca_prestadora;
        this.id_institucion_prestadora = id_institucion_prestadora;
        this.id_estado = id_estado;
        this.id_terminos_envio = id_terminos_envio;
        this.id_item = id_item;
    }
}



