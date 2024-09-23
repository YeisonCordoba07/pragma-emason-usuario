package com.usuario.pragma.emason.application.handler.auth;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Getter
@Service
public class JwtHandler {

    private final SecretKey key = Keys.hmacShaKeyFor("mi_clave_secreta_fija_que_debe_ser_larga_123456".getBytes());


    public String getToken(String email) {
        return Jwts.builder()
                .setSubject(email)  // Se usa el email como subject
                .setIssuedAt(new Date())  // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 180000))
                .signWith(key)  // Firma con la clave secreta
                .compact();  // Compacta y devuelve el token
    }

    public String getToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", "ROLE_" + role)  // Asegúrate de que el rol tenga el prefijo
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + + 180000))
                .signWith(key)
                .compact();
    }


    public String getEmailFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }


    public boolean isTokenValid(String token, String emailAccount) {
        final String email = getEmailFromToken(token);
        return (email.equals(emailAccount) && !isTokenExpired(token));
    }


    private Claims getAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())  // Usa la clave secreta para validar
                .build()
                .parseClaimsJws(token)  // Decodifica el token
                .getBody();  // Devuelve los claims (reclamaciones)
    }


    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }


    public Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }


    public boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
}