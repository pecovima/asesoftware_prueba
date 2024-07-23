package com.asesoftware.prueba.services;

import com.asesoftware.prueba.repoitory.ServicioXMantenimientoRepository;
import com.asesoftware.prueba.model.ServicioXMantenimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioXMantenimientoService {

    @Autowired
    private ServicioXMantenimientoRepository repository;

    public List<ServicioXMantenimiento> findAll() {
        return repository.findAll();
    }

    public Optional<ServicioXMantenimiento> findById(Integer codigo) {
        return repository.findById(codigo);
    }

    public ServicioXMantenimiento save(ServicioXMantenimiento servicioXMantenimiento) {
        return repository.save(servicioXMantenimiento);
    }

    public void deleteById(Integer codigo) {
        repository.deleteById(codigo);
    }
}
