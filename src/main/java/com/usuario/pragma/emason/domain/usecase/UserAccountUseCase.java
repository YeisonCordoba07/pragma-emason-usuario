package com.usuario.pragma.emason.domain.usecase;

import com.usuario.pragma.emason.domain.api.IUserAccountService;
import com.usuario.pragma.emason.domain.model.UserAccount;
import com.usuario.pragma.emason.domain.spi.IUserAccountPersistence;

public class UserAccountUseCase implements IUserAccountService {

    private final IUserAccountPersistence iUserAccountPersistence;

    public UserAccountUseCase(IUserAccountPersistence iUserAccountPersistence) {
        this.iUserAccountPersistence = iUserAccountPersistence;
    }
    @Override
    public void createUserAccount(UserAccount userAccount) {
        iUserAccountPersistence.createUserAccount(userAccount);
    }
}
