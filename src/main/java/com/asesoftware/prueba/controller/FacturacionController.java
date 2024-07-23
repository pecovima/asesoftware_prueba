package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.Factura;
import com.asesoftware.prueba.services.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    @GetMapping("/generar")
    public ResponseEntity<Factura> generarFactura(
            @RequestParam Integer documentoCliente,
            @RequestParam String codPlaca,
            @RequestParam Integer documentoMecanico) {
        try {
            Factura factura = facturacionService.generarFactura(documentoCliente, codPlaca,documentoMecanico);
            return ResponseEntity.ok(factura);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

