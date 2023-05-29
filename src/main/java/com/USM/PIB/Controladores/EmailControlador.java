package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.DetalleEmailModelo;
import com.USM.PIB.Servicios.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailControlador {
    @Autowired
    private EmailService emailService;
    @PostMapping("/sendmail")
    public String
    sendMail(@RequestBody DetalleEmailModelo details)
    {
        String status
                = emailService.sendSimpleMail(details);

        return status;
    }
}
