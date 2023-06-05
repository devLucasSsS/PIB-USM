package com.USM.PIB.Servicios;
import com.USM.PIB.Modelos.DetalleEmailModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServicio {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String emailHost;
    public String enviarEmail(DetalleEmailModelo email)
    {
        try {

            SimpleMailMessage mensajeEmail = new SimpleMailMessage();
            mensajeEmail.setFrom(emailHost);
            mensajeEmail.setTo(email.getRecipient());
            mensajeEmail.setText(email.getMsgBody());
            mensajeEmail.setSubject(email.getSubject());
            javaMailSender.send(mensajeEmail);
            return "Email enviado correctamente...";
        }
        catch (Exception e) {
            return "Error mientras se enviaba el email";
        }
    }
}
