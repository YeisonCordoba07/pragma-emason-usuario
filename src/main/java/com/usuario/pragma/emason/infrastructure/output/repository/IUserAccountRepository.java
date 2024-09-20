package com.usuario.pragma.emason.infrastructure.output.repository;

import com.usuario.pragma.emason.infrastructure.output.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
    UserAccountEntity findByEmail(String email);
}
