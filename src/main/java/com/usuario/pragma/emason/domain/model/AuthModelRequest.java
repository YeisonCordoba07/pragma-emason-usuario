package com.usuario.pragma.emason.domain.model;

public class AuthModelRequest {

    private String email;
    private String password;




    public AuthModelRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthModelRequest(){}




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
