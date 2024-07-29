package com.example.nelumbo.repository;

import com.example.nelumbo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByParqueaderoIdAndFechaSalidaIsNull(Long parqueaderoId);
    Vehiculo findByPlacaAndFechaSalidaIsNull(String placa);
}
