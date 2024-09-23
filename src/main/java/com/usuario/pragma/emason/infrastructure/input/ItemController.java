package com.usuario.pragma.emason.infrastructure.input;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor

public class ItemController {

    @PostMapping("/create")
    public ResponseEntity<String> createItem(@RequestBody String itemString){
        return ResponseEntity.ok("Item created");
    }
}

