package com.usuario.pragma.emason.application.handler.auth;

import com.usuario.pragma.emason.application.dto.auth.AuthResponseDTO;
import com.usuario.pragma.emason.application.dto.auth.LoginRequestDTO;
import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;
import com.usuario.pragma.emason.application.mapper.IUserAccountRequestMapper;
import com.usuario.pragma.emason.domain.api.IUserAccountService;
import com.usuario.pragma.emason.domain.model.UserAccount;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class AuthHandler implements IAuthHandler {

    private final IUserAccountService iUserAccountService;
    private final IUserAccountRequestMapper iUserAccountRequestMapper;

    private final JwtHandler jwtHandler;
    private final AuthenticationManager authenticationManager;



    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
        //UserDetails user = iUserAccountService.findByEmail(loginRequestDTO.getEmail());

        UserAccount userAccount = iUserAccountService.findByEmail(loginRequestDTO.getEmail());

        String token = jwtHandler.getToken(userAccount.getEmail());
        String userRole = userAccount.getRole().toString();

        return AuthResponseDTO.builder()
                .token(token)
                .role(userRole)
                .build();
    }



    @Override
    public AuthResponseDTO register(UserAccountRequestDTO userAccountRequestDTO) {

        UserAccount userAccount = iUserAccountRequestMapper.toUserAccount(userAccountRequestDTO);


        iUserAccountService.createUserAccount(userAccount);

        return AuthResponseDTO.builder()
                .token(jwtHandler.getToken(userAccount.getEmail()))
                .role(userAccount.getRole().toString())
                .build();
    }


}
