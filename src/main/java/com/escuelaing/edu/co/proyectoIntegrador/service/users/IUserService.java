package com.escuelaing.edu.co.proyectoIntegrador.service.users;

import com.escuelaing.edu.co.proyectoIntegrador.exceptions.UserNotFoundException;
import com.escuelaing.edu.co.proyectoIntegrador.repository.User;
import com.escuelaing.edu.co.proyectoIntegrador.repository.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> all();

    void save(User user);

    void update(User user, UserDto userDto) throws UserNotFoundException;

    Optional<User> findById(String id);

    void delete(String id);
}
