package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.DetalleEmailModelo;
import com.USM.PIB.Servicios.EmailServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailControlador {
    @Autowired
    private EmailServicio emailServicio;
    @PostMapping("/enviarEmail")
    public String
    enviarEmail(@RequestBody DetalleEmailModelo correo)
    {
        String estado
                = emailServicio.enviarEmail(correo);

        return estado;
    }
}
