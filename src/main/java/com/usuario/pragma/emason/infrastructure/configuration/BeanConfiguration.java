package com.usuario.pragma.emason.infrastructure.configuration;

import com.usuario.pragma.emason.application.mapper.IUserAccountRequestMapper;
import com.usuario.pragma.emason.domain.api.IUserAccountService;
import com.usuario.pragma.emason.domain.spi.IUserAccountPersistence;
import com.usuario.pragma.emason.domain.usecase.UserAccountUseCase;
import com.usuario.pragma.emason.infrastructure.output.adapter.UserAccountJpaAdapter;
import com.usuario.pragma.emason.infrastructure.output.mapper.IUserAccountEntityMapper;
import com.usuario.pragma.emason.infrastructure.output.repository.IUserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserAccountRepository iUserAccountRepository;
    private final IUserAccountEntityMapper iUserAccountEntityMapper;

    @Bean
    public IUserAccountPersistence iUserAccountPersistence() {
        return new UserAccountJpaAdapter(iUserAccountRepository, iUserAccountEntityMapper);
    }

    @Bean
    public IUserAccountService iUserAccountService() {
        return new UserAccountUseCase(iUserAccountPersistence());
    }
}
