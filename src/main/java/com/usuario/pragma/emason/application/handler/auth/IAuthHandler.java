package com.usuario.pragma.emason.application.handler.auth;

import com.usuario.pragma.emason.application.dto.auth.AuthResponseDTO;
import com.usuario.pragma.emason.application.dto.auth.LoginRequestDTO;
import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;

public interface IAuthHandler {
    AuthResponseDTO register(UserAccountRequestDTO userAccountRequestDTO);
    AuthResponseDTO login(LoginRequestDTO loginRequestDTO);
}
