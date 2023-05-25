package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.ErrorRespuestaModelo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RespuestaPersonalizadaControlador extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex){
        HttpStatus status = (HttpStatus) ex.getStatusCode();
        String mensaje = ex.getReason();
        ErrorRespuestaModelo errorRespuestaModelo = new ErrorRespuestaModelo(status,mensaje);
        return new ResponseEntity<>(errorRespuestaModelo,status);
    }

}
