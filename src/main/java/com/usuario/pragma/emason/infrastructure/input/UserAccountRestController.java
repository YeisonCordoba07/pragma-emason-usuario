package com.usuario.pragma.emason.infrastructure.input;

import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;
import com.usuario.pragma.emason.application.handler.IUserAccountHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserAccountRestController {
    private final IUserAccountHandler iUserAccountHandler;


    @PostMapping("/create")
    public ResponseEntity<Void> saveItem(@Valid @RequestBody UserAccountRequestDTO userAccountRequestDTO) {

        iUserAccountHandler.createUserAccount(userAccountRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
