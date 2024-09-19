package com.usuario.pragma.emason.application.dto;

import jakarta.validation.constraints.AssertFalse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponseDTO {
    String token;
}
