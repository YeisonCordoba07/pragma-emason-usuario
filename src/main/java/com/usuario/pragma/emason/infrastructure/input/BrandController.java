package com.usuario.pragma.emason.infrastructure.input;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor

public class BrandController {



    @PostMapping("/create")
    public ResponseEntity<String> createBrand(@RequestBody String brandString){
        return ResponseEntity.ok("Brand created");
    }
}

