package com.asesoftware.prueba.services;

import com.asesoftware.prueba.model.Marca;
import com.asesoftware.prueba.repoitory.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> findById(Integer codigo) {
        return marcaRepository.findById(codigo);
    }

    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void deleteById(Integer codigo) {
        marcaRepository.deleteById(codigo);
    }
}

