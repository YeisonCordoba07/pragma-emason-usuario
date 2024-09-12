package com.usuario.pragma.emason.infrastructure.output.adapter;

import com.usuario.pragma.emason.domain.model.UserAccount;
import com.usuario.pragma.emason.domain.spi.IUserAccountPersistence;
import com.usuario.pragma.emason.infrastructure.output.entity.UserAccountEntity;
import com.usuario.pragma.emason.infrastructure.output.mapper.IUserAccountEntityMapper;
import com.usuario.pragma.emason.infrastructure.output.repository.IUserAccountRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserAccountJpaAdapter implements IUserAccountPersistence {

    private final IUserAccountRepository iUserAccountRepository;
    private final IUserAccountEntityMapper iUserAccountEntityMapper;



    @Override
    public void createUserAccount(UserAccount userAccount) {
        UserAccountEntity userAccountEntity = iUserAccountEntityMapper.toEntity(userAccount);

        iUserAccountRepository.save(userAccountEntity);
    }
}
