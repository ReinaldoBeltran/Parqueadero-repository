package com.example.nelumbo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(String email, String placa, String mensaje, String parqueaderoNombre) {
        System.out.println("Enviando correo a: " + email);
        System.out.println("Placa: " + placa);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Parqueadero: " + parqueaderoNombre);
    }
}
