package com.usuario.pragma.emason.infrastructure.input;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor

public class SupplyController {

    @PostMapping("/create")
    public ResponseEntity<String> supplyCategory(@RequestBody String supplyString){
        return ResponseEntity.ok("Supply created");
    }
}

