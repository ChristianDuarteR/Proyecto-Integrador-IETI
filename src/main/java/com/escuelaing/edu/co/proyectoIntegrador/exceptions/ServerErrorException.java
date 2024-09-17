package com.escuelaing.edu.co.proyectoIntegrador.exceptions;

public abstract class ServerErrorException extends RuntimeException {

    public ServerErrorException(String message) {
        super(message);
    }
}
