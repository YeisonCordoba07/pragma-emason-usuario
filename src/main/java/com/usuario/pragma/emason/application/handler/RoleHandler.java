package com.usuario.pragma.emason.application.handler;

import com.usuario.pragma.emason.application.dto.RoleResponseDTO;
import com.usuario.pragma.emason.application.mapper.IRoleResponseMapper;
import com.usuario.pragma.emason.domain.api.IRoleService;
import com.usuario.pragma.emason.domain.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RoleHandler implements IRoleHandler{

    private final IRoleService iRoleService;
    private final IRoleResponseMapper iRoleResponseMapper;



    @Override
    public RoleResponseDTO getRoleById(Long id) {
        Role role = iRoleService.getRoleById(id);
        return iRoleResponseMapper.toResponseDTO(role);
    }
}
