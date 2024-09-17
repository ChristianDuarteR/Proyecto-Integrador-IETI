package com.escuelaing.edu.co.proyectoIntegrador.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private Date createdAt;

    private String name;

    private String lastName;

    private String email;

    private String passwordHash;

    private List<RoleEnum> roles;

    public User(String id, Date createdAt, String name, String lastName, String email, String passwordHash) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles = new ArrayList<>(Collections.singleton(RoleEnum.USER));

    }

    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.passwordHash = userDto.getPasswordHash();
        this.createdAt = new Date();
        this.roles = new ArrayList<>(Collections.singleton(RoleEnum.USER));
    }

    public void addRole(RoleEnum role) {
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }
}
