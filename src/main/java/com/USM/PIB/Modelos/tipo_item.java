package com.USM.PIB.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_item")
public class tipo_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_item;
    @Column(name = "nombre_item",length = 45)
    private String nombre_item;
}
