package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.Mantenimiento;
import com.asesoftware.prueba.services.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mantenimientos")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping
    public List<Mantenimiento> getAllMantenimientos() {
        return mantenimientoService.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Mantenimiento> getMantenimientoById(@PathVariable Integer codigo) {
        Optional<Mantenimiento> mantenimiento = mantenimientoService.findById(codigo);
        return mantenimiento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mantenimiento createMantenimiento(@RequestBody Mantenimiento mantenimiento) {
        return mantenimientoService.save(mantenimiento);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Mantenimiento> updateMantenimiento(@PathVariable Integer codigo, @RequestBody Mantenimiento mantenimientoDetails) {
        Optional<Mantenimiento> mantenimientoOptional = mantenimientoService.findById(codigo);
        if (mantenimientoOptional.isPresent()) {
            Mantenimiento mantenimiento = mantenimientoOptional.get();
            mantenimiento.setEstado(mantenimientoDetails.getEstado());
            mantenimiento.setVehiculo(mantenimientoDetails.getVehiculo());
            mantenimiento.setFecha(mantenimientoDetails.getFecha());
            mantenimiento.setMecanico(mantenimientoDetails.getMecanico());
            return ResponseEntity.ok(mantenimientoService.save(mantenimiento));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteMantenimiento(@PathVariable Integer codigo) {
        if (mantenimientoService.findById(codigo).isPresent()) {
            mantenimientoService.deleteById(codigo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

