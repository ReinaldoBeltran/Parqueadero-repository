package com.example.nelumbo.service;

import com.example.nelumbo.model.Vehiculo;
import com.example.nelumbo.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ParqueaderoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Map<String, Object>> obtenerTop10VehiculosRegistrados() {
        return vehiculoRepository.findAll().stream()
                .collect(Collectors.groupingBy(Vehiculo::getPlaca, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(entry -> Map.of("placa", entry.getKey(), "conteo", entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<Map<String, Object>> obtenerTop10VehiculosRegistradosEnParqueadero(Long parqueaderoId) {
        return vehiculoRepository.findByParqueaderoIdAndFechaSalidaIsNull(parqueaderoId).stream()
                .collect(Collectors.groupingBy(Vehiculo::getPlaca, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(entry -> Map.of("placa", entry.getKey(), "conteo", entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<Vehiculo> obtenerVehiculosPorPrimeraVezEnParqueadero(Long parqueaderoId) {
        return vehiculoRepository.findByParqueaderoIdAndFechaSalidaIsNull(parqueaderoId).stream()
                .filter(vehiculo -> vehiculoRepository.countByPlacaAndParqueaderoId(vehiculo.getPlaca(), parqueaderoId) == 1)
                .collect(Collectors.toList());
    }
}
