package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.model.Cliente;
import com.asesoftware.prueba.model.ClienteId;
import com.asesoftware.prueba.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{tipoDocumento}/{documento}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable String tipoDocumento, @PathVariable Integer documento) {
        ClienteId clienteId = new ClienteId();
        clienteId.setTipoDocumento(tipoDocumento);
        clienteId.setDocumento(documento);

        Optional<Cliente> cliente = clienteService.findById(clienteId);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{tipoDocumento}/{documento}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable String tipoDocumento, @PathVariable Integer documento, @RequestBody Cliente clienteDetails) {
        ClienteId clienteId = new ClienteId();
        clienteId.setTipoDocumento(tipoDocumento);
        clienteId.setDocumento(documento);

        Optional<Cliente> clienteOptional = clienteService.findById(clienteId);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setPrimerNombre(clienteDetails.getPrimerNombre());
            cliente.setSegundoNombre(clienteDetails.getSegundoNombre());
            cliente.setPrimerApellido(clienteDetails.getPrimerApellido());
            cliente.setSegundoApellido(clienteDetails.getSegundoApellido());
            cliente.setCelular(clienteDetails.getCelular());
            cliente.setDireccion(clienteDetails.getDireccion());
            cliente.setEmail(clienteDetails.getEmail());
            cliente.setEstado(clienteDetails.getEstado());
            cliente.setPresupuesto(clienteDetails.getPresupuesto());
            return ResponseEntity.ok(clienteService.save(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{tipoDocumento}/{documento}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String tipoDocumento, @PathVariable Integer documento) {
        ClienteId clienteId = new ClienteId();
        clienteId.setTipoDocumento(tipoDocumento);
        clienteId.setDocumento(documento);

        if (clienteService.findById(clienteId).isPresent()) {
            clienteService.deleteById(clienteId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
