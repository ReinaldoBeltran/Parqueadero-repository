package com.example.nelumbo.controller;

import com.example.nelumbo.model.User;
import com.example.nelumbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // La autenticación se maneja a través del filtro JwtAuthenticationFilter
        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // La lógica de logout puede ser manejada en el cliente eliminando el token JWT
        return ResponseEntity.ok().build();
    }
}
