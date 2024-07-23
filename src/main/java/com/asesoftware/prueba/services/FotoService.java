package com.asesoftware.prueba.services;

import com.asesoftware.prueba.model.Foto;
import com.asesoftware.prueba.repoitory.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public List<Foto> findAll() {
        return fotoRepository.findAll();
    }

    public Optional<Foto> findById(Integer codigo) {
        return fotoRepository.findById(codigo);
    }

    public Foto save(Foto foto) {
        return fotoRepository.save(foto);
    }

    public void deleteById(Integer codigo) {
        fotoRepository.deleteById(codigo);
    }
}
