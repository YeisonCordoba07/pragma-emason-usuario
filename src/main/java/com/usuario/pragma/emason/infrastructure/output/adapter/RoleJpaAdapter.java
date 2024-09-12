package com.usuario.pragma.emason.infrastructure.output.adapter;

import com.usuario.pragma.emason.domain.Exception.RoleNotFoundException;
import com.usuario.pragma.emason.domain.model.Role;
import com.usuario.pragma.emason.domain.spi.IRolePersistence;
import com.usuario.pragma.emason.domain.util.DomainConstant;
import com.usuario.pragma.emason.infrastructure.output.entity.RoleEntity;
import com.usuario.pragma.emason.infrastructure.output.mapper.IRoleEntityMapper;
import com.usuario.pragma.emason.infrastructure.output.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistence {

    private final IRoleRepository iRoleRepository;
    private final IRoleEntityMapper iRoleEntityMapper;

    @Override
    public Role getRoleById(Long id) {
        Optional<RoleEntity> optionalRoleEntity = iRoleRepository.findById(id);
        RoleEntity roleEntity = optionalRoleEntity
                .orElseThrow(() -> new RoleNotFoundException(DomainConstant.ROLE_NOT_FOUND_EXCEPTION));
        return iRoleEntityMapper.toRole(roleEntity);
    }
}
