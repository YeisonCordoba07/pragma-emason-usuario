package com.usuario.pragma.emason.infrastructure.output.repository;

import com.usuario.pragma.emason.infrastructure.output.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
}
