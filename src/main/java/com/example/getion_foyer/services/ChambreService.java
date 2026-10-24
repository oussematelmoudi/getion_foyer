package com.example.getion_foyer.services;

import com.example.getion_foyer.entities.Chambre;
import com.example.getion_foyer.repositories.ChambreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {

    private final ChambreRepository repository;

    public ChambreService(ChambreRepository repository) {
        this.repository = repository;
    }

    public List<Chambre> findAll() {
        return repository.findAll();
    }

    public Optional<Chambre> findById(Long id) {
        return repository.findById(id);
    }

    public Chambre add(Chambre chambre) {
        return repository.save(chambre);
    }

    public Chambre modifier(Chambre chambre) {
        return repository.save(chambre);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
