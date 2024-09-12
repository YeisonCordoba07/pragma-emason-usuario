package com.usuario.pragma.emason.domain.spi;

import com.usuario.pragma.emason.domain.model.Role;

public interface IRolePersistence {
    Role getRoleById(Long id);
}
