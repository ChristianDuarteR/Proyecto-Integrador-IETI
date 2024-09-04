package com.escuelaing.edu.co.proyectoIntegrador.service.users;

import com.escuelaing.edu.co.proyectoIntegrador.exceptions.UserNotFoundException;
import com.escuelaing.edu.co.proyectoIntegrador.repository.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> all();

    void save(User user);

    void update(User user, String id) throws UserNotFoundException;

    Optional<User> findById(String id);
}
