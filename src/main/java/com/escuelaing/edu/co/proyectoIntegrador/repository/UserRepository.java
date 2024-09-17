package com.escuelaing.edu.co.proyectoIntegrador.repository;

import com.escuelaing.edu.co.proyectoIntegrador.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String username);
}
