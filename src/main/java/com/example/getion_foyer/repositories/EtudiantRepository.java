package com.example.getion_foyer.repositories;

import com.example.getion_foyer.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<Etudiant> findByDateNaissanceBetween(Date dateDebut, Date dateFin);
}
