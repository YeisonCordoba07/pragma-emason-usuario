package com.usuario.pragma.emason.application.handler;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtHandler {

    private final SecretKey key;

    public JwtHandler() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generate a secure key
    }

    public String getToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .signWith(key)
                .compact();
    }

    public SecretKey getKey() {
        return key;
    }
}