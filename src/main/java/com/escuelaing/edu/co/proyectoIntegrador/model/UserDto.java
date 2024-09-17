package com.escuelaing.edu.co.proyectoIntegrador.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
public class UserDto {
    private String id;
    private Date createdAt;
    private String name;
    private String lastName;
    private String email;
    @Setter
    private String passwordHash;
    private List<RoleEnum> roles;

}
