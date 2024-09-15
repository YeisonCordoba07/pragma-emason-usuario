package com.usuario.pragma.emason.infrastructure.output.mapper;

import com.usuario.pragma.emason.domain.model.Role;
import com.usuario.pragma.emason.infrastructure.output.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleEntityMapper {
    Role toRole(RoleEntity roleEntity);
}
