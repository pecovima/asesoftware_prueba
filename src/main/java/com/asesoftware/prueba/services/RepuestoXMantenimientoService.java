package com.asesoftware.prueba.services;

import com.asesoftware.prueba.repoitory.RepuestoXMantenimientoRepository;
import com.asesoftware.prueba.model.RepuestoXMantenimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepuestoXMantenimientoService {

    @Autowired
    private RepuestoXMantenimientoRepository repository;

    public List<RepuestoXMantenimiento> findAll() {
        return repository.findAll();
    }

    public Optional<RepuestoXMantenimiento> findById(Integer codigo) {
        return repository.findById(codigo);
    }

    public RepuestoXMantenimiento save(RepuestoXMantenimiento repuestoXMantenimiento) {
        return repository.save(repuestoXMantenimiento);
    }

    public void deleteById(Integer codigo) {
        repository.deleteById(codigo);
    }
}
