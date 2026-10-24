package com.example.getion_foyer.controllers;

import com.example.getion_foyer.entities.Bloc;
import com.example.getion_foyer.services.BlocService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocs")
public class BlocController {

    private final BlocService service;

    public BlocController(BlocService service) {
        this.service = service;
    }

    @GetMapping
    public List<Bloc> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bloc create(@RequestBody Bloc bloc) {
        return service.add(bloc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloc> update(@PathVariable Long id, @RequestBody Bloc bloc) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bloc.setIdBloc(id);
        return ResponseEntity.ok(service.modifier(bloc));
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
