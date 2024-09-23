package com.usuario.pragma.emason.infrastructure.input;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor

public class CategoryController {



    @PostMapping("/create")
    public ResponseEntity<String> createCategory(@RequestBody String categoryString){
        return ResponseEntity.ok("Category created");
    }
}
