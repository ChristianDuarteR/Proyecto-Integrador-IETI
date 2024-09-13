package com.escuelaing.edu.co.proyectoIntegrador.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class UserDto {
    private String id;
    private Date createdAt;
    private String name;
    private String lastName;
    private String email;
}
