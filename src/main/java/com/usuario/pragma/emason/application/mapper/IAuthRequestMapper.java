package com.usuario.pragma.emason.application.mapper;

import com.usuario.pragma.emason.application.dto.auth.AuthRequestDTO;
import com.usuario.pragma.emason.domain.model.AuthModelRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IAuthRequestMapper {

    AuthModelRequest toDomain(AuthRequestDTO authRequestDTO);
}
