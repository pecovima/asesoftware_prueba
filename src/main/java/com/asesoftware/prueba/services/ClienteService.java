package com.asesoftware.prueba.services;

import com.asesoftware.prueba.model.Cliente;
import com.asesoftware.prueba.model.ClienteId;
import com.asesoftware.prueba.repoitory.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(ClienteId clienteId) {
        return clienteRepository.findById(clienteId);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(ClienteId clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
