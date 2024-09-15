package com.usuario.pragma.emason.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserAccount {

    private Long id;
    private String name;
    private String lastName;
    private Long identityDocument;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private String password;

    private Long roleId;


    public UserAccount(String name, String lastName, Long identityDocument, String phone, LocalDate birthDate, String email, String password, Long roleId) {
        this.name = name;
        this.lastName = lastName;
        this.identityDocument = identityDocument;
        this.phone = phone;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }


    public UserAccount() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(Long identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
