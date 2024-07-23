package com.asesoftware.prueba.services;

import com.asesoftware.prueba.model.Repuesto;
import com.asesoftware.prueba.repoitory.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepuestoService {

    @Autowired
    private RepuestoRepository repository;

    public List<Repuesto> findAll() {
        return repository.findAll();
    }

    public Optional<Repuesto> findById(Integer codigo) {
        return repository.findById(codigo);
    }

    public Repuesto save(Repuesto repuesto) {
        return repository.save(repuesto);
    }

    public void deleteById(Integer codigo) {
        repository.deleteById(codigo);
    }
}
