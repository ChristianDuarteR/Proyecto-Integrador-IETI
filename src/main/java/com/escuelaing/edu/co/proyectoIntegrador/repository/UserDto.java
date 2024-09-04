package com.escuelaing.edu.co.proyectoIntegrador.repository;

import lombok.Getter;

import java.util.Date;

public class UserDto {
    @Getter
    private final String name;
    @Getter
    private final String lastName;
    @Getter
    private final String email;
    @Getter
    private final String password;


    public UserDto(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}
