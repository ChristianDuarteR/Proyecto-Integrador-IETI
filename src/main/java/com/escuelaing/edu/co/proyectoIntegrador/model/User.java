package com.escuelaing.edu.co.proyectoIntegrador.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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

    public User(String id, Date createdAt, String name, String lastName, String email) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.createdAt = new Date();
    }
}
