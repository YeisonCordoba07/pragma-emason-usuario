package com.usuario.pragma.emason.application.handler;

import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;
import com.usuario.pragma.emason.application.mapper.IUserAccountRequestMapper;
import com.usuario.pragma.emason.domain.api.IUserAccountService;
import com.usuario.pragma.emason.domain.model.UserAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserAccountHandler implements IUserAccountHandler {

    private final IUserAccountService iUserAccountService;
    private final IUserAccountRequestMapper iUserAccountRequestMapper;



    @Override
    public void createUserAccount(UserAccountRequestDTO userAccountRequestDTO) {

        UserAccount userAccount = iUserAccountRequestMapper.toUserAccount(userAccountRequestDTO);
        iUserAccountService.createUserAccount(userAccount);
    }
}
