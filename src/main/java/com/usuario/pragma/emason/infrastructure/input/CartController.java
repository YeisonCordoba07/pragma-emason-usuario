package com.usuario.pragma.emason.infrastructure.input;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody String cartString){
        return ResponseEntity.ok("Cart created");
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeFromCart(@RequestBody String cartString){
        return ResponseEntity.ok("Cart removed");
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyCart(@RequestBody String cartString){
        return ResponseEntity.ok("Buy");
    }
}
