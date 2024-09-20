package com.usuario.pragma.emason.application.handler;

import com.usuario.pragma.emason.application.dto.AuthResponseDTO;
import com.usuario.pragma.emason.application.dto.LoginRequestDTO;
import com.usuario.pragma.emason.application.dto.RegisterRequestDTO;
import com.usuario.pragma.emason.application.mapper.IUserAccountRequestMapper;
import com.usuario.pragma.emason.domain.api.IUserAccountService;
import com.usuario.pragma.emason.domain.model.UserAccount;
import com.usuario.pragma.emason.infrastructure.output.entity.EnumRole;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class AuthHandler implements IAuthHandler {

    private final IUserAccountService iUserAccountService;
    private final JwtHandler jwtHandler;
    private final AuthenticationManager authenticationManager;



    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
        UserDetails user = iUserAccountService.findByEmail(loginRequestDTO.getEmail());
        String token = jwtHandler.getToken(user);
        return AuthResponseDTO.builder()
                .token(token)
                .build();
    }



    @Override
    public AuthResponseDTO register(RegisterRequestDTO registerRequestDTO) {

        UserAccount userAccount = new UserAccount();
        userAccount.setName(registerRequestDTO.getName());
        userAccount.setLastName(registerRequestDTO.getLastName());
        userAccount.setIdentityDocument(registerRequestDTO.getIdentityDocument());
        userAccount.setPhone(registerRequestDTO.getPhone());
        userAccount.setBirthDate(registerRequestDTO.getBirthDate());
        userAccount.setEmail(registerRequestDTO.getEmail());
        userAccount.setPassword(registerRequestDTO.getPassword());
        // Insertar rol manualmente
        userAccount.setRole(EnumRole.AUX_BODEGA);

        iUserAccountService.createUserAccount(userAccount);

        //CUIDADO CON FALLO---------------------------------------------------------
        return AuthResponseDTO.builder()
                .token(jwtHandler.getToken(userAccount))
                .build();
    }


}
