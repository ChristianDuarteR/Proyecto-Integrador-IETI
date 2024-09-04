package com.escuelaing.edu.co.proyectoIntegrador.service.users;

import com.escuelaing.edu.co.proyectoIntegrador.exceptions.UserNotFoundException;
import com.escuelaing.edu.co.proyectoIntegrador.repository.User;
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
        users.put(user.getId(), user);
    }

    @Override
    public void update(User user, String id) {
        try {
            User optionalUser = users.get(id);
            if (optionalUser == null) throw new UserNotFoundException(id);
            else {
                optionalUser.setName(user.getName());
                optionalUser.setLastName(user.getLastName());
                optionalUser.setEmail(user.getEmail());
            }
        } catch (UserNotFoundException e){
            e.getCause();
        }
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.of(users.get(id));
    }
}
