package com.escuelaing.edu.co.proyectoIntegrador.exceptions;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String id) {
        super(id);
    }

}
