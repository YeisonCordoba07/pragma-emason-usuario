package com.usuario.pragma.emason.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name no be blank")
    private String name;

    @NotNull(message = "Last name is required")
    @NotBlank(message = "Last no be blank")
    private String lastName;

    @NotNull(message = "Identity document is required")
    private Long identityDocument;

    @Size(min = 7, max = 13, message = "Phone number must be between 7 and 13 digits")
    private String phone;

    @NotNull(message = "Birth date is required")
    private LocalDate birthDate;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email no be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @NotBlank(message = "Password is required")
    private String password;

    @NotNull(message = "Role is required")
    private Long roleId;

}
