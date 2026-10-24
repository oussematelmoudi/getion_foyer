package com.example.getion_foyer.repositories;

import com.example.getion_foyer.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
