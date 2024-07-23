package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.RepuestoXMantenimiento;
import com.asesoftware.prueba.services.RepuestoXMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/repuestosxmantenimientos")
public class RepuestoXMantenimientoController {

    @Autowired
    private RepuestoXMantenimientoService service;

    @GetMapping
    public List<RepuestoXMantenimiento> getAll() {
        return service.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<RepuestoXMantenimiento> getById(@PathVariable Integer codigo) {
        Optional<RepuestoXMantenimiento> entity = service.findById(codigo);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RepuestoXMantenimiento create(@RequestBody RepuestoXMantenimiento entity) {
        return service.save(entity);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<RepuestoXMantenimiento> update(@PathVariable Integer codigo, @RequestBody RepuestoXMantenimiento entityDetails) {
        Optional<RepuestoXMantenimiento> entityOptional = service.findById(codigo);
        if (entityOptional.isPresent()) {
            RepuestoXMantenimiento entity = entityOptional.get();
            entity.setUnidades(entityDetails.getUnidades());
            entity.setTiempoEstimado(entityDetails.getTiempoEstimado());
            entity.setMantenimiento(entityDetails.getMantenimiento());
            entity.setRepuesto(entityDetails.getRepuesto());
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

