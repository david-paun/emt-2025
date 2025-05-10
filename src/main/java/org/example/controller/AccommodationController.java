package org.example.controller;

import org.example.dto.AccommodationRequest;
import org.example.model.Accommodation;
import org.example.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController {

    private final AccommodationService service;

    public AccommodationController(AccommodationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Accommodation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AccommodationRequest req) {
        return service.addAccommodation(req);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AccommodationRequest req) {
        return service.updateAccommodation(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.deleteAccommodation(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/rent")
    public ResponseEntity<Accommodation> markAsRented(@PathVariable Long id) {
        return service.markAsRented(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
