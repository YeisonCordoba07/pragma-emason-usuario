package com.usuario.pragma.emason.domain.usecase;

import com.usuario.pragma.emason.domain.Exception.RoleNotFoundException;
import com.usuario.pragma.emason.domain.Exception.UnderAgeException;
import com.usuario.pragma.emason.domain.api.IUserAccountService;
import com.usuario.pragma.emason.domain.model.UserAccount;
import com.usuario.pragma.emason.domain.spi.IRolePersistence;
import com.usuario.pragma.emason.domain.spi.IUserAccountPersistence;
import com.usuario.pragma.emason.domain.util.DomainConstant;
import com.usuario.pragma.emason.domain.util.EncryptPassword;

import java.time.LocalDate;
import java.time.Period;

public class UserAccountUseCase implements IUserAccountService {

    private final IUserAccountPersistence iUserAccountPersistence;
    private final IRolePersistence iRolePersistence;

    public UserAccountUseCase(IUserAccountPersistence iUserAccountPersistence, IRolePersistence iRolePersistence) {
        this.iUserAccountPersistence = iUserAccountPersistence;
        this.iRolePersistence = iRolePersistence;
    }



    @Override
    public void createUserAccount(UserAccount userAccount) {
        if(!isAdult(userAccount.getBirthDate())){
            throw new UnderAgeException(DomainConstant.UNDER_AGE_EXCEPTION);
        }
        if(iRolePersistence.getRoleById(userAccount.getRoleId()) == null){
            throw new RoleNotFoundException(DomainConstant.ROLE_NOT_FOUND_EXCEPTION);
        }
        userAccount.setPassword(EncryptPassword.encryptPassword(userAccount.getPassword()));
        iUserAccountPersistence.createUserAccount(userAccount);
    }


    public boolean isAdult(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        return age.getYears() >= 18;
    }
}
