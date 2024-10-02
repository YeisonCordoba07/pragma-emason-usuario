package com.usuario.pragma.emason.domain.api;

import com.usuario.pragma.emason.domain.model.AuthModelRequest;

public interface IAuthService {

    AuthModelRequest login(AuthModelRequest authModelRequest);
}
