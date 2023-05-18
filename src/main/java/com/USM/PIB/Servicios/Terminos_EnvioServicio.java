package com.USM.PIB.Servicios;

import com.USM.PIB.Modelos.Terminos_envioModelo;
import com.USM.PIB.Repositorios.Terminos_EnvioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Terminos_EnvioServicio {

    @Autowired
    Terminos_EnvioRepositorio terminosEnvioRepositorio;

    public Terminos_envioModelo saveTerminosEnvio(Terminos_envioModelo terminosEnvio){
        return terminosEnvioRepositorio.save(terminosEnvio);
    }

    public Terminos_envioModelo getByIdPet0(int idPeticion) {
        return terminosEnvioRepositorio.getByIdPet0(idPeticion);
    }
    public Terminos_envioModelo getByIdPet1(int idPeticion) {
        return terminosEnvioRepositorio.getByIdPet1(idPeticion);
    }

}
