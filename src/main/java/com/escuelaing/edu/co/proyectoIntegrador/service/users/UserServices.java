package com.escuelaing.edu.co.proyectoIntegrador.service.users;

import com.escuelaing.edu.co.proyectoIntegrador.model.User;
import com.escuelaing.edu.co.proyectoIntegrador.model.UserDto;
import com.escuelaing.edu.co.proyectoIntegrador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServices implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            System.err.println("Error al guardar el usuario: " + e.getCause());
            e.printStackTrace();
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
        return userRepository.findById(id);
    }

    @Override
    public void delete(String id){
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String username) {
        return userRepository.findByEmail(username);
    }
}
