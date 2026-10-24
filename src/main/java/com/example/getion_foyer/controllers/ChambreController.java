package com.example.getion_foyer.controllers;

import com.example.getion_foyer.entities.Chambre;
import com.example.getion_foyer.services.ChambreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    private final ChambreService service;

    public ChambreController(ChambreService service) {
        this.service = service;
    }

    @GetMapping
    public List<Chambre> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Chambre create(@RequestBody Chambre chambre) {
        return service.add(chambre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> update(@PathVariable Long id, @RequestBody Chambre chambre) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        chambre.setIdChambre(id);
        return ResponseEntity.ok(service.modifier(chambre));
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
