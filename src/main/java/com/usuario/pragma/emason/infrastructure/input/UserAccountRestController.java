package com.usuario.pragma.emason.infrastructure.input;

import com.usuario.pragma.emason.application.dto.UserAccountRequestDTO;
import com.usuario.pragma.emason.application.handler.IUserAccountHandler;
import com.usuario.pragma.emason.infrastructure.util.ApiDocumentationConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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



    @Operation(
            summary = ApiDocumentationConstants.OPERATION_SUMMARY_CREATE,
            description = ApiDocumentationConstants.OPERATION_DESCRIPTION_CREATE
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = ApiDocumentationConstants.STATUS_201,
                    description = ApiDocumentationConstants.RESPONSE_201_DESCRIPTION),
            @ApiResponse(
                    responseCode = ApiDocumentationConstants.STATUS_400,
                    description = ApiDocumentationConstants.RESPONSE_400_DESCRIPTION,
                    content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(
                    responseCode = ApiDocumentationConstants.STATUS_500,
                    description = ApiDocumentationConstants.RESPONSE_500_DESCRIPTION)
    })
    @PostMapping("/create")
    public ResponseEntity<Void> createUserAccount(@Valid @RequestBody UserAccountRequestDTO userAccountRequestDTO) {

        iUserAccountHandler.createUserAccount(userAccountRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
