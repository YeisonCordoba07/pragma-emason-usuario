package com.usuario.pragma.emason.application.dto;


import com.usuario.pragma.emason.application.util.ApplicationConstants;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserAccountRequestDTO {
    @NotNull(message = ApplicationConstants.NAME_REQUIRED)
    @NotBlank(message = ApplicationConstants.NAME_NOT_BLANK)
    private String name;

    @NotNull(message = ApplicationConstants.LAST_NAME_REQUIRED)
    @NotBlank(message = ApplicationConstants.LAST_NAME_NOT_BLANK)
    private String lastName;

    @NotNull(message = ApplicationConstants.IDENTITY_DOCUMENT_REQUIRED)
    private Long identityDocument;

    @Size(min = 7, max = 13, message = ApplicationConstants.PHONE_SIZE)
    private String phone;

    @NotNull(message = ApplicationConstants.BIRTH_DATE_REQUIRED)
    private LocalDate birthDate;

    @NotNull(message = ApplicationConstants.EMAIL_REQUIRED)
    @NotBlank(message = ApplicationConstants.EMAIL_NOT_BLANK)
    @Email(message = ApplicationConstants.EMAIL_VALID)
    private String email;

    @NotNull
    @NotBlank(message = ApplicationConstants.PASSWORD_REQUIRED)
    private String password;

    @NotNull(message = ApplicationConstants.ROLE_ID_REQUIRED)
    private Long roleId;
}
