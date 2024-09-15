package com.usuario.pragma.emason.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserAccountResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private Long identityDocument;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private String password;

    private Long roleId;
}
