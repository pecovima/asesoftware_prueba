package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.Vehiculo;
import com.asesoftware.prueba.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoService.findAll();
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable String placa) {
        Optional<Vehiculo> vehiculo = vehiculoService.findById(placa);
        return vehiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.save(vehiculo);
    }

    @PutMapping("/{placa}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable String placa, @RequestBody Vehiculo vehiculoDetails) {
        Optional<Vehiculo> vehiculoOptional = vehiculoService.findById(placa);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            vehiculo.setColor(vehiculoDetails.getColor());
            vehiculo.setMarca(vehiculoDetails.getMarca());
            vehiculo.setCliente(vehiculoDetails.getCliente());
            return ResponseEntity.ok(vehiculoService.save(vehiculo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable String placa) {
        if (vehiculoService.findById(placa).isPresent()) {
            vehiculoService.deleteById(placa);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
