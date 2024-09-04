package com.escuelaing.edu.co.proyectoIntegrador.controller.users;


import com.escuelaing.edu.co.proyectoIntegrador.exceptions.UserNotFoundException;
import com.escuelaing.edu.co.proyectoIntegrador.repository.UserDto;
import com.escuelaing.edu.co.proyectoIntegrador.service.users.IUserService;
import com.escuelaing.edu.co.proyectoIntegrador.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")

public class UserController {

    private final IUserService userServices;

    public UserController(@Autowired IUserService userServices) {
        this.userServices = userServices;
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
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
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
}
