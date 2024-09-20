package com.usuario.pragma.emason.infrastructure.input;

import com.usuario.pragma.emason.application.dto.AuthResponseDTO;
import com.usuario.pragma.emason.application.dto.LoginRequestDTO;
import com.usuario.pragma.emason.application.dto.RegisterRequestDTO;
import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;
import com.usuario.pragma.emason.application.handler.IAuthHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final IAuthHandler iAuthHandler;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(iAuthHandler.login(loginRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody UserAccountRequestDTO userAccountRequestDTO){
        return ResponseEntity.ok(iAuthHandler.register(userAccountRequestDTO));
    }
}
