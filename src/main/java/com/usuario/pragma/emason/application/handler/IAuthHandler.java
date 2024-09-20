package com.usuario.pragma.emason.application.handler;

import com.usuario.pragma.emason.application.dto.AuthResponseDTO;
import com.usuario.pragma.emason.application.dto.LoginRequestDTO;
import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;

public interface IAuthHandler {
    AuthResponseDTO register(UserAccountRequestDTO userAccountRequestDTO);
    AuthResponseDTO login(LoginRequestDTO loginRequestDTO);
}
