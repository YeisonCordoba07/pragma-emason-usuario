package com.usuario.pragma.emason.infrastructure.configuration;

import com.usuario.pragma.emason.domain.api.IRoleService;
import com.usuario.pragma.emason.domain.api.IUserAccountService;
import com.usuario.pragma.emason.domain.spi.IEncryptPassword;
import com.usuario.pragma.emason.domain.spi.IRolePersistence;
import com.usuario.pragma.emason.domain.spi.IUserAccountPersistence;
import com.usuario.pragma.emason.domain.usecase.RoleUseCase;
import com.usuario.pragma.emason.domain.usecase.UserAccountUseCase;
import com.usuario.pragma.emason.infrastructure.output.adapter.RoleJpaAdapter;
import com.usuario.pragma.emason.infrastructure.output.adapter.UserAccountJpaAdapter;
import com.usuario.pragma.emason.infrastructure.output.mapper.IRoleEntityMapper;
import com.usuario.pragma.emason.infrastructure.output.mapper.IUserAccountEntityMapper;
import com.usuario.pragma.emason.infrastructure.output.repository.IRoleRepository;
import com.usuario.pragma.emason.infrastructure.output.repository.IUserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserAccountRepository iUserAccountRepository;
    private final IUserAccountEntityMapper iUserAccountEntityMapper;
    private final IEncryptPassword iEncryptPassword;

    private final IRoleRepository iRoleRepository;
    private final IRoleEntityMapper iRoleEntityMapper;


    @Bean
    public IUserAccountPersistence iUserAccountPersistence() {
        return new UserAccountJpaAdapter(iUserAccountRepository, iUserAccountEntityMapper, iEncryptPassword);
    }

    @Bean
    public IUserAccountService iUserAccountService() {
        return new UserAccountUseCase(iUserAccountPersistence());
    }



    @Bean
    public IRolePersistence iRolePersistence() {
        return new RoleJpaAdapter(iRoleRepository, iRoleEntityMapper);
    }

    @Bean
    public IRoleService iRoleService() {
        return new RoleUseCase(iRolePersistence());
    }
}
