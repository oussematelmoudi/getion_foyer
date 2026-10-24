package com.example.getion_foyer.services;

import com.example.getion_foyer.entities.Universite;
import com.example.getion_foyer.repositories.UniversiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService {

    private final UniversiteRepository repository;

    public UniversiteService(UniversiteRepository repository) {
        this.repository = repository;
    }

    public List<Universite> findAll() {
        return repository.findAll();
    }

    public Optional<Universite> findById(Long id) {
        return repository.findById(id);
    }

    public Universite add(Universite universite) {
        return repository.save(universite);
    }

    public Universite modifier(Universite universite) {
        return repository.save(universite);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
