package com.USM.PIB.Modelos;

// Java Program to Illustrate EmailDetails Class


// Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor

// Class
public class DetalleEmailModelo {

    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
}