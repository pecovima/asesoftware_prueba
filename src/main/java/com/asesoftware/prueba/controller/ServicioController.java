package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.Servicio;
import com.asesoftware.prueba.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<Servicio> getAllServicios() {
        return servicioService.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable Integer codigo) {
        Optional<Servicio> servicio = servicioService.findById(codigo);
        return servicio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Servicio createServicio(@RequestBody Servicio servicio) {

        return servicioService.save(servicio);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable Integer codigo, @RequestBody Servicio servicioDetails) {
        Optional<Servicio> servicioOptional = servicioService.findById(codigo);
        if (servicioOptional.isPresent()) {
            Servicio servicio = servicioOptional.get();
            servicio.setNombreServicio(servicioDetails.getNombreServicio());
            servicio.setPrecio(servicioDetails.getPrecio());
            return ResponseEntity.ok(servicioService.save(servicio));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Integer codigo) {
        if (servicioService.findById(codigo).isPresent()) {
            servicioService.deleteById(codigo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

