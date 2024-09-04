package com.escuelaing.edu.co.proyectoIntegrador.service.users;

import com.escuelaing.edu.co.proyectoIntegrador.repository.User;
import com.escuelaing.edu.co.proyectoIntegrador.repository.UserDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServices implements IUserService{

    private final Map<String, User> users = new HashMap<>();

    @Override
    public List<User> all() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void save(User user) {
        try {
            user.setId(users.size() + 1);
            if (users.containsKey(user.getId())) {
                throw new IllegalArgumentException("El Id del usuario ya está en uso: " + user.getId());
            }
            users.put(user.getId(), user);
        } catch (Exception e) {
            System.err.println("Error al guardar el usuario: " + e.getCause());
        }
    }

    @Override
    public void update(User user, UserDto userDto) {
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }
}
