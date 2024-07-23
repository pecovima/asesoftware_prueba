package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.services.ServicioXMantenimientoService;
import com.asesoftware.prueba.model.ServicioXMantenimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/serviciosxmantenimientos")
public class ServicioXMantenimientoController {

    @Autowired
    private ServicioXMantenimientoService service;

    @GetMapping
    public List<ServicioXMantenimiento> getAll() {
        return service.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ServicioXMantenimiento> getById(@PathVariable Integer codigo) {
        Optional<ServicioXMantenimiento> entity = service.findById(codigo);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ServicioXMantenimiento create(@RequestBody ServicioXMantenimiento entity) {
        return service.save(entity);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ServicioXMantenimiento> update(@PathVariable Integer codigo, @RequestBody ServicioXMantenimiento entityDetails) {
        Optional<ServicioXMantenimiento> entityOptional = service.findById(codigo);
        if (entityOptional.isPresent()) {
            ServicioXMantenimiento entity = entityOptional.get();
            entity.setTiempoEstimado(entityDetails.getTiempoEstimado());
            entity.setServicio(entityDetails.getServicio());
            entity.setMantenimiento(entityDetails.getMantenimiento());
            return ResponseEntity.ok(service.save(entity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable Integer codigo) {
        if (service.findById(codigo).isPresent()) {
            service.deleteById(codigo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
