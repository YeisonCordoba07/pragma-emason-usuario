package com.usuario.pragma.emason.domain.usecase;

import com.usuario.pragma.emason.domain.api.IRoleService;
import com.usuario.pragma.emason.domain.model.Role;
import com.usuario.pragma.emason.domain.spi.IRolePersistence;

public class RoleUseCase implements IRoleService {
    private final IRolePersistence iRolePersistence;



    public RoleUseCase(IRolePersistence iRolePersistence) {
        this.iRolePersistence = iRolePersistence;
    }



    @Override
    public Role getRoleById(Long id) {
        return iRolePersistence.getRoleById(id);
    }


}
