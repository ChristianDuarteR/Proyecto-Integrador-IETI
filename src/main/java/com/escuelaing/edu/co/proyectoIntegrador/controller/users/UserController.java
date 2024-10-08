package com.escuelaing.edu.co.proyectoIntegrador.controller.users;


import com.escuelaing.edu.co.proyectoIntegrador.exceptions.UserNotFoundException;
import com.escuelaing.edu.co.proyectoIntegrador.exceptions.UserWithEmailAlreadyRegisteredException;
import com.escuelaing.edu.co.proyectoIntegrador.model.UserDto;
import com.escuelaing.edu.co.proyectoIntegrador.service.users.IUserService;
import com.escuelaing.edu.co.proyectoIntegrador.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")

public class UserController {

    private final IUserService userServices;

    private final PasswordEncoder passwordEncoder;


    public UserController(@Autowired IUserService userServices, PasswordEncoder passwordEncoder) {
        this.userServices = userServices;
        this.passwordEncoder = passwordEncoder;
        loadSampleUsers();

    }

    public void loadSampleUsers() {
        if (passwordEncoder != null) {
            User userEntity = new User("1",new Date(),"Christian","Duarte","christian@gmail.com",passwordEncoder.encode("password"));
            userServices.save(userEntity);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userServices.all();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        Optional<User> user = userServices.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) throws UserWithEmailAlreadyRegisteredException {
        Optional<User> optionalUser = userServices.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()){
            throw new UserWithEmailAlreadyRegisteredException();
        }
        userDto.setPasswordHash(passwordEncoder.encode(userDto.getPasswordHash()));
        User user = new User(userDto);
        userServices.save(user);
        URI createdUserUri = URI.create("/v1/users/");
        return ResponseEntity.created(createdUserUri).body(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id,
                                           @RequestBody UserDto userDto) throws UserNotFoundException {
        Optional<User> optionalUser = userServices.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            userServices.update(user, userDto);
            return ResponseEntity.ok(user);
        }else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        Optional<User> optionalUser = userServices.findById(id);
        if (optionalUser.isPresent()) {
            userServices.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
