package com.usuario.pragma.emason.infrastructure.input;


import com.usuario.pragma.emason.application.dto.RoleResponseDTO;
import com.usuario.pragma.emason.application.handler.IRoleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@Validated
public class RoleRestController {
    private final IRoleHandler iRoleHandler;

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> getRoleById(@PathVariable Long id) {
        return ResponseEntity.ok(iRoleHandler.getRoleById(id));
    }

}
