package com.asesoftware.prueba.services;
import com.asesoftware.prueba.model.Mantenimiento;
import com.asesoftware.prueba.repoitory.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    public List<Mantenimiento> findAll() {
        return mantenimientoRepository.findAll();
    }

    public Optional<Mantenimiento> findById(Integer codigo) {
        return mantenimientoRepository.findById(codigo);
    }

    public Mantenimiento save(Mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    public void deleteById(Integer codigo) {
        mantenimientoRepository.deleteById(codigo);
    }
}

