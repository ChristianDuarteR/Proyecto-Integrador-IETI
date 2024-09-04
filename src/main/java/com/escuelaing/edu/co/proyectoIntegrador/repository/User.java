package com.escuelaing.edu.co.proyectoIntegrador.repository;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class User {

    @Getter
    private final String id;

    @Getter
    private final Date createdAt;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter

    private String lastName;

    @Getter
    @Setter
    private String email;

    public User(String id, String name, String lastName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = new Date();
    }

    public User(UserDto userDto) {
        this.id = null;
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.createdAt = new Date();

    }
}
