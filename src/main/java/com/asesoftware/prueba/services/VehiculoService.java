package com.asesoftware.prueba.services;

import com.asesoftware.prueba.model.Vehiculo;
import com.asesoftware.prueba.repoitory.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> findById(String placa) {
        return vehiculoRepository.findById(placa);
    }

    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public void deleteById(String placa) {
        vehiculoRepository.deleteById(placa);
    }
}

