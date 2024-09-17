package com.escuelaing.edu.co.proyectoIntegrador.controller.auth;


import com.escuelaing.edu.co.proyectoIntegrador.exceptions.InvalidCredentialsException;
import com.escuelaing.edu.co.proyectoIntegrador.model.LoginDto;
import com.escuelaing.edu.co.proyectoIntegrador.model.TokenDto;
import com.escuelaing.edu.co.proyectoIntegrador.model.User;
import com.escuelaing.edu.co.proyectoIntegrador.security.JwtUtil;
import com.escuelaing.edu.co.proyectoIntegrador.service.users.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/auth")
public class AuthenticationController {

    private final UserServices userServices;

    private final JwtUtil jwtUtil;


    public AuthenticationController(UserServices userServices, JwtUtil jwtUtil) {
        this.userServices = userServices;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) throws InvalidCredentialsException {
        Optional<User> optionalUser =userServices.findByEmail(loginDto.getUsername());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if(BCrypt.checkpw(loginDto.getPassword(), user.getPasswordHash())){
                TokenDto tokenDto = jwtUtil.generateToken(user.getEmail(), user.getRoles());
                return ResponseEntity.ok(tokenDto);
            }else {
                throw new InvalidCredentialsException();
            }
        }else {
            throw new InvalidCredentialsException();
        }
    }
}
