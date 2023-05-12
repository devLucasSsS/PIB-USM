package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.Terminos_envioModelo;
import com.USM.PIB.Servicios.Terminos_EnvioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/terminos-envio")
public class Terminos_EnvioControlador {

    @Autowired
    Terminos_EnvioServicio terminosEnvioServicio;

    public Terminos_envioModelo saveTerminosEnvio(@RequestBody Terminos_envioModelo terminosEnvio){
        return terminosEnvioServicio.saveTerminosEnvio(terminosEnvio);
    }
}
