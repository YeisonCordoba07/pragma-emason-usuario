package com.usuario.pragma.emason.infrastructure.output.repository;

import com.usuario.pragma.emason.infrastructure.output.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
    Optional<UserAccountEntity> findByEmail(String email);
}
