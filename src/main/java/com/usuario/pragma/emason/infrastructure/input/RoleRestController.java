package com.usuario.pragma.emason.infrastructure.input;


import com.usuario.pragma.emason.application.dto.RoleResponseDTO;
import com.usuario.pragma.emason.application.handler.IRoleHandler;
import com.usuario.pragma.emason.domain.model.Role;
import com.usuario.pragma.emason.infrastructure.util.ApiDocumentationConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@Validated
public class RoleRestController {
    private final IRoleHandler iRoleHandler;


    @Operation(
            summary = ApiDocumentationConstants.OPERATION_SUMMARY_GET_BY_ID,
            description = ApiDocumentationConstants.OPERATION_DESCRIPTION_GET_BY_ID
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = ApiDocumentationConstants.STATUS_200,
                    description = ApiDocumentationConstants.RESPONSE_200_DESCRIPTION),
            @ApiResponse(
                    responseCode = ApiDocumentationConstants.STATUS_404,
                    description = ApiDocumentationConstants.RESPONSE_404_DESCRIPTION)
    })
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> getRoleById(
            @Parameter(description = ApiDocumentationConstants.PATH_PARAM_DESCRIPTION)
            @PathVariable Long id) {
        return ResponseEntity.ok(iRoleHandler.getRoleById(id));
    }




}
