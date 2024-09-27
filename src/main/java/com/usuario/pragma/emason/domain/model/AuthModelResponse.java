package com.usuario.pragma.emason.domain.model;

public class AuthModelResponse {

    String token;
    String role;



    public AuthModelResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    public AuthModelResponse(){}




    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
