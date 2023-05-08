package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_item")
public class Tipo_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_item;
    @Column(name = "nombre_item",length = 45)
    private String nombre_item;

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getNombre_item() {
        return nombre_item;
    }

    public void setNombre_item(String nombre_item) {
        this.nombre_item = nombre_item;
    }

    public Tipo_item() {
    }

    public Tipo_item(int id_item, String nombre_item) {
        this.id_item = id_item;
        this.nombre_item = nombre_item;
    }
}
