package com.usuario.pragma.emason.infrastructure.output.mapper;

import com.usuario.pragma.emason.domain.model.UserAccount;
import com.usuario.pragma.emason.infrastructure.output.entity.EnumRole;
import com.usuario.pragma.emason.infrastructure.output.entity.UserAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserAccountEntityMapper {


    default UserAccountEntity toEntity(UserAccount userAccount){
        UserAccountEntity userAccountEntity = new UserAccountEntity();

        userAccountEntity.setName(userAccount.getName());
        userAccountEntity.setLastName(userAccount.getLastName());
        userAccountEntity.setIdentityDocument(userAccount.getIdentityDocument());
        userAccountEntity.setPhone(userAccount.getPhone());
        userAccountEntity.setBirthDate(userAccount.getBirthDate());
        userAccountEntity.setEmail(userAccount.getEmail());
        userAccountEntity.setPassword(userAccount.getPassword());

        //RoleEntity roleEntity = new RoleEntity();

        //roleEntity.setId(userAccount.getRoleId());
        userAccountEntity.setRole(EnumRole.AUX_BODEGA);
        return userAccountEntity;
    }



    default UserAccount toUserAccount(UserAccountEntity userAccountEntity){
        UserAccount userAccount = new UserAccount();

        userAccount.setName(userAccountEntity.getName());
        userAccount.setLastName(userAccountEntity.getLastName());
        userAccount.setIdentityDocument(userAccountEntity.getIdentityDocument());
        userAccount.setPhone(userAccountEntity.getPhone());
        userAccount.setBirthDate(userAccountEntity.getBirthDate());
        userAccount.setEmail(userAccountEntity.getEmail());
        userAccount.setPassword(userAccountEntity.getPassword());

        //RoleEntity roleEntity = new RoleEntity();

        //roleEntity.setId(userAccount.getRoleId());
        userAccount.setRole(userAccountEntity.getRole());
        return userAccount;
    }


}
