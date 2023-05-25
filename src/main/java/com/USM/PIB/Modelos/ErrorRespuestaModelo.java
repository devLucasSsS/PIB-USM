package com.USM.PIB.Modelos;

import org.springframework.http.HttpStatus;

public class ErrorRespuestaModelo {
    private HttpStatus status;
    private String mensaje;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ErrorRespuestaModelo(HttpStatus status, String mensaje) {
        this.status = status;
        this.mensaje = mensaje;
    }

    public ErrorRespuestaModelo() {
    }
}
