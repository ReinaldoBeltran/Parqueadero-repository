package com.example.nelumbo.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String fechaIngreso;
    private String fechaSalida;
    
    @ManyToOne
    @JoinColumn(name = "parqueadero_id")
    private Parqueadero parqueadero;
}
