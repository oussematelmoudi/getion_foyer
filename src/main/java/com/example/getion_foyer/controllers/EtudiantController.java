package com.example.getion_foyer.controllers;

import com.example.getion_foyer.entities.Etudiant;
import com.example.getion_foyer.services.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Etudiant> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/date-naissance")
    public List<Etudiant> getByDateNaissance(@RequestParam Date debut, @RequestParam Date fin) {
        return service.findByDateNaissanceBetween(debut, fin);
    }

    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant) {
        return service.add(etudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> update(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        etudiant.setIdEtudiant(id);
        return ResponseEntity.ok(service.modifier(etudiant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
