package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.Mecanico;
import com.asesoftware.prueba.services.MecanicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/mecanicos")
@Validated
public class MecanicoController {

    private final MecanicoService mecanicoService;

    public MecanicoController(MecanicoService mecanicoService) {
        this.mecanicoService = mecanicoService;
    }

    @PostMapping
    public ResponseEntity<String> insertarMecanico(@Valid @RequestBody Mecanico request) {
        try {
            mecanicoService.insertarMecanico(
                    request.getPrimerNombre(),
                    request.getSegundoNombre(),
                    request.getPrimerApellido(),
                    request.getSegundoApellido(),
                    request.getTipoDocumento(),
                    request.getDocumento(),
                    request.getCelular(),
                    request.getDireccion(),
                    request.getEmail(),
                    request.getEstado()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body("Mecánico insertado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar mecánico.");
        }
    }
    @GetMapping("/disponibles")
    public List<Mecanico> listarMecanicosDisponibles() {
        try {
           return  mecanicoService.listarMecanicosDisponibles();

        } catch (Exception e) {
            return (List<Mecanico>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar mecánico.");
        }

    }

}

