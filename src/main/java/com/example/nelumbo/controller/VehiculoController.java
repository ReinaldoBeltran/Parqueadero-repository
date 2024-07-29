package com.example.nelumbo.controller;

import com.example.nelumbo.model.Vehiculo;
import com.example.nelumbo.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/parqueadero/{parqueaderoId}")
    public List<Vehiculo> findByParqueaderoId(@PathVariable Long parqueaderoId) {
        return vehiculoService.findByParqueaderoId(parqueaderoId);
    }

    @PostMapping
    public Vehiculo save(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.save(vehiculo);
    }

    @PostMapping("/registrar-ingreso")
    public ResponseEntity<?> registrarIngreso(@RequestBody Map<String, String> request) {
        String placa = request.get("placa");
        Long parqueaderoId = Long.parseLong(request.get("parqueaderoId"));

        try {
            Vehiculo vehiculo = vehiculoService.registrarIngreso(placa, parqueaderoId);
            Map<String, Long> response = new HashMap<>();
            response.put("id", vehiculo.getId());
            return ResponseEntity.status(201).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("mensaje", e.getMessage()));
        }
    }

    @PostMapping("/registrar-salida")
    public ResponseEntity<?> registrarSalida(@RequestBody Map<String, String> request) {
        String placa = request.get("placa");
        Long parqueaderoId = Long.parseLong(request.get("parqueaderoId"));

        try {
            vehiculoService.registrarSalida(placa, parqueaderoId);
            return ResponseEntity.ok(Map.of("mensaje", "Salida registrada"));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("mensaje", e.getMessage()));
        }
    }
}
