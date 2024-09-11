package com.usuario.pragma.emason.infrastructure.output.mapper;

import com.usuario.pragma.emason.domain.model.UserAccount;
import com.usuario.pragma.emason.infrastructure.output.entity.UserAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserAccountEntityMapper {
    UserAccountEntity toEntity(UserAccount userAccount);
    UserAccount toUserAccount(UserAccountEntity userAccountEntity);

}
