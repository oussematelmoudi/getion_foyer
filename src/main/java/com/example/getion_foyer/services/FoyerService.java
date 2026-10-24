package com.example.getion_foyer.services;

import com.example.getion_foyer.entities.Foyer;
import com.example.getion_foyer.repositories.FoyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerService {

    private final FoyerRepository repository;

    public FoyerService(FoyerRepository repository) {
        this.repository = repository;
    }

    public List<Foyer> findAll() {
        return repository.findAll();
    }

    public Optional<Foyer> findById(Long id) {
        return repository.findById(id);
    }

    public Foyer add(Foyer foyer) {
        return repository.save(foyer);
    }

    public Foyer modifier(Foyer foyer) {
        return repository.save(foyer);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
