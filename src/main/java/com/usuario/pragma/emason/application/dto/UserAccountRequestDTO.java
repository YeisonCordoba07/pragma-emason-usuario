package com.usuario.pragma.emason.application.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserAccountRequestDTO {
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name no be blank")
    private String name;

    @NotNull(message = "Last name is required")
    @NotBlank(message = "Last no be blank")
    private String lastName;

    @NotNull(message = "Identity document is required")
    private Long identityDocument;

    @NotNull(message = "Phone is required")
    @NotBlank(message = "Phone no be blank")
    @Size(min = 7, max = 13, message = "Phone number must be between 7 and 13 digits")
    //@Pattern(regexp = "\\+?\\d{1,13}", message = "Phone number must be a maximum of 13 digits and can contain the '+' symbol")
    private String phone;

    @NotNull(message = "Birth date is required")
    private LocalDate birthDate;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email no be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;

    @NotNull(message = "Role is required")
    private Long roleId;

}
