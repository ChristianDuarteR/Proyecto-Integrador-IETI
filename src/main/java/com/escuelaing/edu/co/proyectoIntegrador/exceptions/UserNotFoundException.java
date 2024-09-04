package com.escuelaing.edu.co.proyectoIntegrador.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String id) {
        super(id);
    }
}
