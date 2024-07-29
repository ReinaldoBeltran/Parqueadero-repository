package com.example.nelumbo.service;

import com.example.nelumbo.model.Parqueadero;
import com.example.nelumbo.model.Vehiculo;
import com.example.nelumbo.repository.ParqueaderoRepository;
import com.example.nelumbo.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    @Autowired
    private EmailService emailService;

    public List<Vehiculo> findByParqueaderoId(Long parqueaderoId) {
        return vehiculoRepository.findByParqueaderoIdAndFechaSalidaIsNull(parqueaderoId);
    }

    public Vehiculo findByPlaca(String placa) {
        return vehiculoRepository.findByPlacaAndFechaSalidaIsNull(placa);
    }

    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo registrarIngreso(String placa, Long parqueaderoId) {
        Parqueadero parqueadero = parqueaderoRepository.findById(parqueaderoId).orElseThrow(() -> new RuntimeException("Parqueadero no encontrado"));

        if (vehiculoRepository.findByPlacaAndFechaSalidaIsNull(placa) != null) {
            throw new RuntimeException("No se puede Registrar Ingreso ya existe la placa en este u otro parqueadero");
        }

        if (vehiculoRepository.countByParqueaderoIdAndFechaSalidaIsNull(parqueaderoId) >= parqueadero.getCapacidad()) {
            throw new RuntimeException("No se puede Registrar Ingreso, el parqueadero ha alcanzado su capacidad máxima");
        }

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(placa);
        vehiculo.setParqueadero(parqueadero);
        vehiculo.setFechaIngreso(LocalDateTime.now().toString());
        vehiculo = vehiculoRepository.save(vehiculo);

        // Llamar al microservicio de simulación de envío de correos
        emailService.sendEmail(parqueadero.getSocio().getEmail(), placa, "Ingreso registrado", parqueadero.getNombre());

        return vehiculo;
    }

    public void registrarSalida(String placa, Long parqueaderoId) {
        Vehiculo vehiculo = vehiculoRepository.findByPlacaAndFechaSalidaIsNull(placa);
        if (vehiculo == null || !vehiculo.getParqueadero().getId().equals(parqueaderoId)) {
            throw new RuntimeException("No se puede Registrar Salida no existe la placa en el parqueadero");
        }
        vehiculo.setFechaSalida(LocalDateTime.now().toString());
        vehiculoRepository.save(vehiculo);
    }
}
