package com.usuario.pragma.emason.application.mapper;


import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;
import com.usuario.pragma.emason.domain.model.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserAccountRequestMapper {

    UserAccount toUserAccount(UserAccountRequestDTO userAccountRequestDTO);
}
