package com.example.getion_foyer.controllers;

import com.example.getion_foyer.entities.Universite;
import com.example.getion_foyer.services.UniversiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    private final UniversiteService service;

    public UniversiteController(UniversiteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Universite> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universite> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Universite create(@RequestBody Universite universite) {
        return service.add(universite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universite> update(@PathVariable Long id, @RequestBody Universite universite) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        universite.setIdUniversite(id);
        return ResponseEntity.ok(service.modifier(universite));
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
