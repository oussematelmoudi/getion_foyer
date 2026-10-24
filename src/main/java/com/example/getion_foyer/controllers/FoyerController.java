package com.example.getion_foyer.controllers;

import com.example.getion_foyer.entities.Foyer;
import com.example.getion_foyer.services.FoyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foyers")
public class FoyerController {

    private final FoyerService service;

    public FoyerController(FoyerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Foyer> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Foyer create(@RequestBody Foyer foyer) {
        return service.add(foyer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foyer> update(@PathVariable Long id, @RequestBody Foyer foyer) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        foyer.setIdFoyer(id);
        return ResponseEntity.ok(service.modifier(foyer));
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
