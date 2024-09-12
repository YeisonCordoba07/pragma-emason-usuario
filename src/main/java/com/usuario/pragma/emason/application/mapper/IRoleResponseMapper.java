package com.usuario.pragma.emason.application.mapper;

import com.usuario.pragma.emason.application.dto.RoleResponseDTO;
import com.usuario.pragma.emason.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleResponseMapper {
    RoleResponseDTO toResponseDTO(Role role);
}
