package com.escuelaing.edu.co.proyectoIntegrador.model;


import lombok.Getter;

@Getter
public class LoginDto {

    private final String username;

    private final String password;

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
