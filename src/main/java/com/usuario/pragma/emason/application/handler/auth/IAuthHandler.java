package com.usuario.pragma.emason.application.handler.auth;

import com.usuario.pragma.emason.application.dto.auth.AuthRequestDTO;
import com.usuario.pragma.emason.application.dto.auth.AuthResponseDTO;
import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;

public interface IAuthHandler {
    AuthResponseDTO register(UserAccountRequestDTO userAccountRequestDTO);
    AuthResponseDTO login(AuthRequestDTO authRequestDTO);
}
