package com.usuario.pragma.emason.infrastructure.input;

import com.usuario.pragma.emason.application.dto.auth.AuthRequestDTO;
import com.usuario.pragma.emason.application.dto.auth.AuthResponseDTO;

import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;
import com.usuario.pragma.emason.application.handler.auth.IAuthHandler;
import com.usuario.pragma.emason.infrastructure.util.ApiDocumentationConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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



    @Operation(summary = ApiDocumentationConstants.LOGIN_SUMMARY, description = ApiDocumentationConstants.LOGIN_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ApiDocumentationConstants.STATUS_200, description = ApiDocumentationConstants.SUCCESSFULLY_AUTHENTICATED,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthResponseDTO.class))),
            @ApiResponse(responseCode = ApiDocumentationConstants.STATUS_400, description = ApiDocumentationConstants.INVALID_CREDENTIALS,
                    content = @Content),
            @ApiResponse(responseCode = ApiDocumentationConstants.STATUS_500, description = ApiDocumentationConstants.SERVER_ERROR,
                    content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authRequestDTO){
        return ResponseEntity.ok(iAuthHandler.login(authRequestDTO));
    }



    @Operation(summary = ApiDocumentationConstants.REGISTER_SUMMARY, description = ApiDocumentationConstants.REGISTER_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ApiDocumentationConstants.STATUS_200, description = ApiDocumentationConstants.SUCCESSFULLY_REGISTERED,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthResponseDTO.class))),
            @ApiResponse(responseCode = ApiDocumentationConstants.STATUS_400, description = ApiDocumentationConstants.INVALID_INPUT_DATA,
                    content = @Content),
            @ApiResponse(responseCode = ApiDocumentationConstants.STATUS_500, description = ApiDocumentationConstants.SERVER_ERROR,
                    content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody UserAccountRequestDTO userAccountRequestDTO){
        return ResponseEntity.ok(iAuthHandler.register(userAccountRequestDTO));
    }
}
