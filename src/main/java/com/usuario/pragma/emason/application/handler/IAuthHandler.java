package com.usuario.pragma.emason.application.handler;

import com.usuario.pragma.emason.application.dto.AuthResponseDTO;
import com.usuario.pragma.emason.application.dto.LoginRequestDTO;
import com.usuario.pragma.emason.application.dto.RegisterRequestDTO;

public interface IAuthHandler {
    AuthResponseDTO register(RegisterRequestDTO registerRequestDTO);
    AuthResponseDTO login(LoginRequestDTO loginRequestDTO);
}
