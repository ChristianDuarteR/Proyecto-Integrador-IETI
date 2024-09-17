package com.escuelaing.edu.co.proyectoIntegrador.exceptions;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException() {
        super("invalid username or password");
    }

}
