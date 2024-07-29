package com.example.nelumbo.repository;

import com.example.nelumbo.model.Parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Long> {
    List<Parqueadero> findBySocioId(Long socioId);
}
