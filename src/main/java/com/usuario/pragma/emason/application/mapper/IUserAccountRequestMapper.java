package com.usuario.pragma.emason.application.mapper;

import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;
import com.usuario.pragma.emason.domain.model.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserAccountRequestMapper {

    default UserAccount toUserAccount(UserAccountRequestDTO userAccountRequestDTO){

        UserAccount userAccount = new  UserAccount();
        userAccount.setName(userAccountRequestDTO.getName());
        userAccount.setLastName(userAccountRequestDTO.getLastName());
        userAccount.setIdentityDocument(userAccountRequestDTO.getIdentityDocument());
        userAccount.setPhone(userAccountRequestDTO.getPhone());
        userAccount.setBirthDate(userAccountRequestDTO.getBirthDate());
        userAccount.setEmail(userAccountRequestDTO.getEmail());
        userAccount.setPassword(userAccountRequestDTO.getPassword());
        userAccount.setRole(userAccountRequestDTO.getRole());

        return userAccount;
    }
}
