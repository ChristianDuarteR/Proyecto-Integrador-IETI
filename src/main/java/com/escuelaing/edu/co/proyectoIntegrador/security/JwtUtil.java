package com.escuelaing.edu.co.proyectoIntegrador.security;

import com.escuelaing.edu.co.proyectoIntegrador.model.RoleEnum;
import com.escuelaing.edu.co.proyectoIntegrador.model.TokenDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.escuelaing.edu.co.proyectoIntegrador.utils.Constants.CLAIMS_ROLES_KEY;

@Component
public class JwtUtil {

    private final JwtConfig jwtConfig;

    public JwtUtil(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public TokenDto generateToken(String username, List<RoleEnum> roles) {
        Date expirationDate= jwtConfig.getExpirationDate();
        String token = Jwts.builder().subject(username)
                .issuedAt(new Date())
                .expiration(expirationDate)
                .claim(CLAIMS_ROLES_KEY, roles)
                .signWith(jwtConfig.getSigningKey())
                .compact();
        return new TokenDto(token, expirationDate);

    }

    public Claims extractAndVerifyClaims(String token) {
        return Jwts.parser()
                .verifyWith(jwtConfig.getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
