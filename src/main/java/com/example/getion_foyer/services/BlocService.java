package com.example.getion_foyer.services;

import com.example.getion_foyer.entities.Bloc;
import com.example.getion_foyer.repositories.BlocRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlocService {

    private final BlocRepository repository;

    public BlocService(BlocRepository repository) {
        this.repository = repository;
    }

    public List<Bloc> findAll() {
        return repository.findAll();
    }

    public Optional<Bloc> findById(Long id) {
        return repository.findById(id);
    }

    public Bloc add(Bloc bloc) {
        return repository.save(bloc);
    }

    public Bloc modifier(Bloc bloc) {
        return repository.save(bloc);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
