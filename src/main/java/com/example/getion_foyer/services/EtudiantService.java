package com.example.getion_foyer.services;

import com.example.getion_foyer.entities.Etudiant;
import com.example.getion_foyer.repositories.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository repository;

    public EtudiantService(EtudiantRepository repository) {
        this.repository = repository;
    }

    public List<Etudiant> findAll() {
        return repository.findAll();
    }

    public Optional<Etudiant> findById(Long id) {
        return repository.findById(id);
    }

    public List<Etudiant> findByDateNaissanceBetween(Date debut, Date fin) {
        return repository.findByDateNaissanceBetween(debut, fin);
    }

    public Etudiant add(Etudiant etudiant) {
        return repository.save(etudiant);
    }

    public Etudiant modifier(Etudiant etudiant) {
        return repository.save(etudiant);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
