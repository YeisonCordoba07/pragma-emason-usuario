package com.usuario.pragma.emason.domain.usecase;


import com.usuario.pragma.emason.domain.exception.AccessDeniedException;
import com.usuario.pragma.emason.domain.exception.RoleNotFoundException;
import com.usuario.pragma.emason.domain.exception.UnderAgeException;
import com.usuario.pragma.emason.domain.api.IUserAccountService;
import com.usuario.pragma.emason.domain.model.EnumRole;
import com.usuario.pragma.emason.domain.model.UserAccount;
import com.usuario.pragma.emason.domain.spi.IUserAccountPersistence;
import com.usuario.pragma.emason.domain.util.DomainConstant;

import java.time.LocalDate;
import java.time.Period;

public class UserAccountUseCase implements IUserAccountService {

    private final IUserAccountPersistence iUserAccountPersistence;



    public UserAccountUseCase(IUserAccountPersistence iUserAccountPersistence) {
        this.iUserAccountPersistence = iUserAccountPersistence;

    }



    @Override
    public void createUserAccount(UserAccount userAccount) {
        if(!isAdult(userAccount.getBirthDate())){
            throw new UnderAgeException(DomainConstant.UNDER_AGE_EXCEPTION);
        }
        if(userAccount.getRole() == EnumRole.ADMIN){
            throw new AccessDeniedException(DomainConstant.ACCESS_DENIED_EXCEPTION_MESSAGE);
        }

        iUserAccountPersistence.createUserAccount(userAccount);
    }



    @Override
    public UserAccount findByEmail(String email) {
        return iUserAccountPersistence.findByEmail(email);
    }



    public boolean isAdult(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        return age.getYears() >= 18;
    }
}
