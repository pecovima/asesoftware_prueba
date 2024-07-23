package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.Marca;
import com.asesoftware.prueba.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> getAllMarcas() {
        return marcaService.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable Integer codigo) {
        Optional<Marca> marca = marcaService.findById(codigo);
        return marca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Marca createMarca(@RequestBody Marca marca) {
        return marcaService.save(marca);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Marca> updateMarca(@PathVariable Integer codigo, @RequestBody Marca marcaDetails) {
        Optional<Marca> marcaOptional = marcaService.findById(codigo);
        if (marcaOptional.isPresent()) {
            Marca marca = marcaOptional.get();
            marca.setNombreMarca(marcaDetails.getNombreMarca());
            return ResponseEntity.ok(marcaService.save(marca));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Integer codigo) {
        if (marcaService.findById(codigo).isPresent()) {
            marcaService.deleteById(codigo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
