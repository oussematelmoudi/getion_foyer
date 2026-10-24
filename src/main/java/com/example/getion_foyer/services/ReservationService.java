package com.example.getion_foyer.services;

import com.example.getion_foyer.entities.Reservation;
import com.example.getion_foyer.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> findAll() {
        return repository.findAll();
    }

    public Optional<Reservation> findById(String id) {
        return repository.findById(id);
    }

    public Reservation add(Reservation reservation) {
        return repository.save(reservation);
    }

    public Reservation modifier(Reservation reservation) {
        return repository.save(reservation);
    }

    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
