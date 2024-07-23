package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.Repuesto;
import com.asesoftware.prueba.services.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoService service;

    @GetMapping
    public List<Repuesto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Repuesto> getById(@PathVariable Integer codigo) {
        Optional<Repuesto> entity = service.findById(codigo);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Repuesto create(@RequestBody Repuesto entity) {
        return service.save(entity);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Repuesto> update(@PathVariable Integer codigo, @RequestBody Repuesto entityDetails) {
        Optional<Repuesto> entityOptional = service.findById(codigo);
        if (entityOptional.isPresent()) {
            Repuesto entity = entityOptional.get();
            entity.setNombreRepuesto(entityDetails.getNombreRepuesto());
            entity.setPrecioUnitario(entityDetails.getPrecioUnitario());
            entity.setUnidadesInventario(entityDetails.getUnidadesInventario());
            entity.setProveedor(entityDetails.getProveedor());
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
