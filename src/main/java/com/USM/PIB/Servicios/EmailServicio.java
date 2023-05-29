package com.USM.PIB.Servicios;

// Java Program to Illustrate Creation Of
// Service Interface


// Importing required classes
import com.USM.PIB.Modelos.DetalleEmailModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// Interface
@Service
public class EmailServicio {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String emailHost;
    public String enviarEmail(DetalleEmailModelo email)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mensajeEmail
                    = new SimpleMailMessage();

            // Setting up necessary details
            mensajeEmail.setFrom(emailHost);
            mensajeEmail.setTo(email.getRecipient());
            mensajeEmail.setText(email.getMsgBody());
            mensajeEmail.setSubject(email.getSubject());

            // Sending the mail
            javaMailSender.send(mensajeEmail);
            return "Email enviado correctamente...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error mientras se enviaba el email";
        }
    }
}
