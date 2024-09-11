package com.usuario.pragma.emason.domain.spi;

import com.usuario.pragma.emason.domain.model.UserAccount;

public interface IUserAccountPersistence {
    void createUserAccount(UserAccount userAccount);
}
