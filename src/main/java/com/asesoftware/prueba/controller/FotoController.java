package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.Foto;
import com.asesoftware.prueba.services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fotos")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @GetMapping
    public List<Foto> getAllFotos() {
        return fotoService.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Foto> getFotoById(@PathVariable Integer codigo) {
        Optional<Foto> foto = fotoService.findById(codigo);
        return foto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Foto createFoto(@RequestBody Foto foto) {
        return fotoService.save(foto);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Foto> updateFoto(@PathVariable Integer codigo, @RequestBody Foto fotoDetails) {
        Optional<Foto> fotoOptional = fotoService.findById(codigo);
        if (fotoOptional.isPresent()) {
            Foto foto = fotoOptional.get();
            foto.setRuta(fotoDetails.getRuta());
            foto.setMantenimiento(fotoDetails.getMantenimiento());
            return ResponseEntity.ok(fotoService.save(foto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteFoto(@PathVariable Integer codigo) {
        if (fotoService.findById(codigo).isPresent()) {
            fotoService.deleteById(codigo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
