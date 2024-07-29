package com.example.nelumbo.controller;

import com.example.nelumbo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String placa = request.get("placa");
        String mensaje = request.get("mensaje");
        String parqueaderoNombre = request.get("parqueaderoNombre");

        emailService.sendEmail(email, placa, mensaje, parqueaderoNombre);

        return ResponseEntity.ok(Map.of("mensaje", "Correo Enviado"));
    }
}
