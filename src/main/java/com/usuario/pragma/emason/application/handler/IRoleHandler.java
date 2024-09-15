package com.usuario.pragma.emason.application.handler;

import com.usuario.pragma.emason.application.dto.RoleResponseDTO;

public interface IRoleHandler {
    RoleResponseDTO getRoleById(Long id);
}
