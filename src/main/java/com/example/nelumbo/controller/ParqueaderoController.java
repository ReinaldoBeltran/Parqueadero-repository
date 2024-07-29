package com.example.nelumbo.controller;

import com.example.nelumbo.model.Vehiculo;
import com.example.nelumbo.service.ParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/parqueaderos")
public class ParqueaderoController {

    @Autowired
    private ParqueaderoService parqueaderoService;

    @GetMapping("/indicadores/top10")
    public List<Map<String, Object>> obtenerTop10VehiculosRegistrados() {
        return parqueaderoService.obtenerTop10VehiculosRegistrados();
    }

    @GetMapping("/indicadores/top10/{parqueaderoId}")
    public List<Map<String, Object>> obtenerTop10VehiculosRegistradosEnParqueadero(@PathVariable Long parqueaderoId) {
        return parqueaderoService.obtenerTop10VehiculosRegistradosEnParqueadero(parqueaderoId);
    }

    @GetMapping("/indicadores/primera-vez/{parqueaderoId}")
    public List<Vehiculo> obtenerVehiculosPorPrimeraVezEnParqueadero(@PathVariable Long parqueaderoId) {
        return parqueaderoService.obtenerVehiculosPorPrimeraVezEnParqueadero(parqueaderoId);
    }
}
